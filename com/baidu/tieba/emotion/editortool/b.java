package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tieba.d;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b extends NoPressedLinearLayout implements s, EmotionTabContentView.c, EmotionTabWidgetView.a {
    private int Ja;
    private i Jb;
    private CustomMessageListener Tc;
    private int aEm;
    private int aph;
    private EmotionTabContentView cjj;
    private EmotionTabWidgetView cjk;
    private View cjl;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cjm;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cjn;
    private String cjo;
    private boolean cjp;
    private boolean cjq;
    private int cjr;
    private CustomMessageListener cjs;

    public b(Context context) {
        super(context);
        this.cjm = new ArrayList<>();
        this.cjn = new ArrayList<>();
        this.aEm = -1;
        this.cjo = null;
        this.aph = -1;
        this.cjp = true;
        this.cjq = true;
        this.cjr = 0;
        this.Ja = 0;
        this.Tc = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED /* 2001117 */:
                        b.this.reset();
                        b.this.setup();
                        return;
                    default:
                        return;
                }
            }
        };
        this.cjs = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && b.this.cjm.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < b.this.cjm.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) b.this.cjm.get(i2)).Di() != EmotionGroupType.USER_COLLECT) {
                                i = i2 + 1;
                            } else {
                                b.this.setCurrentEmotionGroup(i2);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(d.h.emotion_tab_host, (ViewGroup) this, true);
        this.cjj = (EmotionTabContentView) findViewById(d.g.face_tab_content);
        this.cjk = (EmotionTabWidgetView) findViewById(d.g.face_tab_widget);
        this.cjl = findViewById(d.g.emotion_tab_widget_div_line);
        this.cjk.setOnTabSelectedListener(this);
        this.cjj.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aph = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.aph);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.cjk != null) {
            this.cjk.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.cjq = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aeD() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = g.aeN().aeP().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.Di() != EmotionGroupType.BIG_EMOTION || this.cjp) {
                if (next.Di() != EmotionGroupType.USER_COLLECT || this.cjq) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.cjm = g.aeN().aeP();
        if (!this.cjp || !this.cjq) {
            this.cjn = aeD();
            if (!this.cjq && this.cjm != null) {
                this.cjm = new ArrayList<>(g.aeN().aeP());
                int i = 0;
                while (true) {
                    if (i < this.cjm.size()) {
                        if (this.cjm.get(i).Di() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.cjm.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.cjn = g.aeN().aeP();
        }
        if ((this.cjm == null || this.cjm.size() <= 0) && this.cjr < 3) {
            this.cjr++;
            g.aeN().aeO();
            return;
        }
        this.cjk.setDatas(this.cjm);
        int size = this.cjm.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.cjm.get(i3);
            if (this.cjo != null && this.cjo.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.Tc);
        MessageManager.getInstance().registerListener(this.cjs);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.Tc);
        MessageManager.getInstance().unRegisterListener(this.cjs);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aph) {
            this.aph = skinType;
            onChangeSkinType(this.aph);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cjk.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.cjn.size() && i != this.aEm) {
            this.cjj.i(this.cjn, i);
            this.cjk.setCurrentTab(i);
            this.aEm = i;
            this.cjo = this.cjn.get(i).getGroupId();
        }
    }

    public void reset() {
        this.aEm = -1;
        this.cjm.clear();
        this.cjj.reset();
        this.cjk.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.cjp = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void fc(int i) {
        if (i >= 0 && i < this.cjm.size() && i != this.aEm && this.cjj != null) {
            this.cjj.iF(i);
            this.aEm = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        this.cjk.onChangeSkinType(i);
        this.cjj.onChangeSkinType(i);
        aj.e(this.cjl, d.C0080d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void iG(int i) {
        if (this.cjk != null && i != this.aEm) {
            this.cjk.setCurrentTab(i);
            this.aEm = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 34:
                    if (aVar.data instanceof Integer) {
                        setFrom(((Integer) aVar.data).intValue());
                        return;
                    }
                    return;
                case 35:
                    if (aVar.data instanceof Boolean) {
                        boolean booleanValue = ((Boolean) aVar.data).booleanValue();
                        setShowBigEmotion(booleanValue);
                        if (!booleanValue) {
                            ArrayList arrayList = new ArrayList();
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cjn.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.Dh()) {
                                    arrayList.add(next);
                                }
                            }
                            this.cjj.i(arrayList, 0);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Jb = iVar;
        this.cjj.setOnDataSelected(iVar);
        this.cjk.setOnDataSelected(iVar);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Jb != null) {
            this.Jb.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Ja = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Ja;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lG() {
        if (this.cjk != null) {
            int size = this.cjm.size();
            for (int i = 0; i < size; i++) {
                this.cjk.m(i, this.cjp);
            }
            this.cjk.setTabWidgetBigEmontionVisibility(this.cjp);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }
}
