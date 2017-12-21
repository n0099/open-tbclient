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
    private i IS;
    private int IT;
    private CustomMessageListener TG;
    private int aEV;
    private int apG;
    private EmotionTabContentView csd;
    private EmotionTabWidgetView cse;
    private View csf;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> csg;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> csh;
    private String csi;
    private boolean csj;
    private boolean csk;
    private int csl;
    private CustomMessageListener csm;

    public b(Context context) {
        super(context);
        this.csg = new ArrayList<>();
        this.csh = new ArrayList<>();
        this.aEV = -1;
        this.csi = null;
        this.apG = -1;
        this.csj = true;
        this.csk = true;
        this.csl = 0;
        this.IT = 0;
        this.TG = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.b.1
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
        this.csm = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && b.this.csg.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < b.this.csg.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) b.this.csg.get(i2)).Dt() != EmotionGroupType.USER_COLLECT) {
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
        this.csd = (EmotionTabContentView) findViewById(d.g.face_tab_content);
        this.cse = (EmotionTabWidgetView) findViewById(d.g.face_tab_widget);
        this.csf = findViewById(d.g.emotion_tab_widget_div_line);
        this.cse.setOnTabSelectedListener(this);
        this.csd.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.apG = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.apG);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.cse != null) {
            this.cse.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.csk = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> agw() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = g.agG().agI().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.Dt() != EmotionGroupType.BIG_EMOTION || this.csj) {
                if (next.Dt() != EmotionGroupType.USER_COLLECT || this.csk) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.csg = g.agG().agI();
        if (!this.csj || !this.csk) {
            this.csh = agw();
            if (!this.csk && this.csg != null) {
                this.csg = new ArrayList<>(g.agG().agI());
                int i = 0;
                while (true) {
                    if (i < this.csg.size()) {
                        if (this.csg.get(i).Dt() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.csg.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.csh = g.agG().agI();
        }
        if ((this.csg == null || this.csg.size() <= 0) && this.csl < 3) {
            this.csl++;
            g.agG().agH();
            return;
        }
        this.cse.setDatas(this.csg);
        int size = this.csg.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.csg.get(i3);
            if (this.csi != null && this.csi.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.TG);
        MessageManager.getInstance().registerListener(this.csm);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.TG);
        MessageManager.getInstance().unRegisterListener(this.csm);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.apG) {
            this.apG = skinType;
            onChangeSkinType(this.apG);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cse.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.csh.size() && i != this.aEV) {
            this.csd.i(this.csh, i);
            this.cse.setCurrentTab(i);
            this.aEV = i;
            this.csi = this.csh.get(i).getGroupId();
        }
    }

    public void reset() {
        this.aEV = -1;
        this.csg.clear();
        this.csd.reset();
        this.cse.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.csj = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void fb(int i) {
        if (i >= 0 && i < this.csg.size() && i != this.aEV && this.csd != null) {
            this.csd.jf(i);
            this.aEV = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        this.cse.onChangeSkinType(i);
        this.csd.onChangeSkinType(i);
        aj.e(this.csf, d.C0095d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void jg(int i) {
        if (this.cse != null && i != this.aEV) {
            this.cse.setCurrentTab(i);
            this.aEV = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.csh.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.Ds()) {
                                    arrayList.add(next);
                                }
                            }
                            this.csd.i(arrayList, 0);
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
        this.IS = iVar;
        this.csd.setOnDataSelected(iVar);
        this.cse.setOnDataSelected(iVar);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.IS != null) {
            this.IS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.IT = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.IT;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lE() {
        if (this.cse != null) {
            int size = this.csg.size();
            for (int i = 0; i < size; i++) {
                this.cse.m(i, this.csj);
            }
            this.cse.setTabWidgetBigEmontionVisibility(this.csj);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }
}
