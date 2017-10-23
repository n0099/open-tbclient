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
    private int JG;
    private i JH;
    private CustomMessageListener SH;
    private int aDt;
    private int aoN;
    private EmotionTabContentView cbp;
    private EmotionTabWidgetView cbq;
    private View cbr;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cbs;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cbt;
    private String cbu;
    private boolean cbv;
    private boolean cbw;
    private boolean cbx;
    private int cby;
    private CustomMessageListener cbz;

    public b(Context context) {
        super(context);
        this.cbs = new ArrayList<>();
        this.cbt = new ArrayList<>();
        this.aDt = -1;
        this.cbu = null;
        this.aoN = -1;
        this.cbw = true;
        this.cbx = true;
        this.cby = 0;
        this.JG = 0;
        this.SH = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.b.1
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
        this.cbz = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && b.this.cbs.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < b.this.cbs.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) b.this.cbs.get(i2)).CI() != EmotionGroupType.USER_COLLECT) {
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
        LayoutInflater.from(context).inflate(d.j.emotion_tab_host, (ViewGroup) this, true);
        this.cbp = (EmotionTabContentView) findViewById(d.h.face_tab_content);
        this.cbq = (EmotionTabWidgetView) findViewById(d.h.face_tab_widget);
        this.cbr = findViewById(d.h.emotion_tab_widget_div_line);
        this.cbq.setOnTabSelectedListener(this);
        this.cbp.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aoN = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.aoN);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.cbq != null) {
            this.cbq.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.cbx = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aci() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = g.acs().acu().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.CI() != EmotionGroupType.BIG_EMOTION || this.cbw) {
                if (next.CI() != EmotionGroupType.USER_COLLECT || this.cbx) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.cbs = g.acs().acu();
        if (!this.cbw || !this.cbx) {
            this.cbt = aci();
            if (!this.cbx && this.cbs != null) {
                this.cbs = new ArrayList<>(g.acs().acu());
                int i = 0;
                while (true) {
                    if (i < this.cbs.size()) {
                        if (this.cbs.get(i).CI() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.cbs.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.cbt = g.acs().acu();
        }
        if ((this.cbs == null || this.cbs.size() <= 0) && this.cby < 3) {
            this.cby++;
            g.acs().act();
            return;
        }
        this.cbq.setDatas(this.cbs);
        int size = this.cbs.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.cbs.get(i3);
            if (this.cbu != null && this.cbu.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.SH);
        MessageManager.getInstance().registerListener(this.cbz);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.SH);
        MessageManager.getInstance().unRegisterListener(this.cbz);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aoN) {
            this.aoN = skinType;
            onChangeSkinType(this.aoN);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cbq.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.cbt.size() && i != this.aDt) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.cbt.get(i);
            this.cbp.h(this.cbt, i);
            if (this.cbv) {
                if (cVar.CI() == EmotionGroupType.LOCAL) {
                    this.cbq.setShowDelete(true);
                } else {
                    this.cbq.setShowDelete(false);
                }
            }
            this.cbq.setCurrentTab(i);
            this.aDt = i;
            this.cbu = cVar.getGroupId();
        }
    }

    public void reset() {
        this.aDt = -1;
        this.cbs.clear();
        this.cbp.reset();
        this.cbq.reset();
    }

    public void setIsInChat(boolean z) {
        this.cbv = z;
        this.cbq.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.cbw = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void fc(int i) {
        if (i >= 0 && i < this.cbs.size() && i != this.aDt && this.cbp != null) {
            this.cbp.io(i);
            this.aDt = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        this.cbq.onChangeSkinType(i);
        this.cbp.onChangeSkinType(i);
        aj.e(this.cbr, d.e.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void ip(int i) {
        if (this.cbq != null && i != this.aDt) {
            this.cbq.setCurrentTab(i);
            this.aDt = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cbt.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.CH()) {
                                    arrayList.add(next);
                                }
                            }
                            this.cbp.h(arrayList, 0);
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
        this.JH = iVar;
        this.cbp.setOnDataSelected(iVar);
        this.cbq.setOnDataSelected(iVar);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JH != null) {
            this.JH.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.JG = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.JG;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lM() {
        if (this.cbq != null) {
            int size = this.cbs.size();
            for (int i = 0; i < size; i++) {
                this.cbq.k(i, this.cbw);
            }
            this.cbq.setTabWidgetBigEmontionVisibility(this.cbw);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }
}
