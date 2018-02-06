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
    private CustomMessageListener aJC;
    private i axP;
    private int axQ;
    private int bfL;
    private int bvs;
    private EmotionTabContentView dop;
    private EmotionTabWidgetView doq;
    private View dor;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dos;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dot;
    private String dou;
    private boolean dov;
    private boolean dow;
    private int dox;
    private CustomMessageListener doy;

    public b(Context context) {
        super(context);
        this.dos = new ArrayList<>();
        this.dot = new ArrayList<>();
        this.bvs = -1;
        this.dou = null;
        this.bfL = -1;
        this.dov = true;
        this.dow = true;
        this.dox = 0;
        this.axQ = 0;
        this.aJC = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                switch (customResponsedMessage.getCmd()) {
                    case 2001117:
                        b.this.reset();
                        b.this.setup();
                        return;
                    default:
                        return;
                }
            }
        };
        this.doy = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && b.this.dos.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < b.this.dos.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) b.this.dos.get(i2)).Lr() != EmotionGroupType.USER_COLLECT) {
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
        this.dop = (EmotionTabContentView) findViewById(d.g.face_tab_content);
        this.doq = (EmotionTabWidgetView) findViewById(d.g.face_tab_widget);
        this.dor = findViewById(d.g.emotion_tab_widget_div_line);
        this.doq.setOnTabSelectedListener(this);
        this.dop.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.bfL = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.bfL);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.doq != null) {
            this.doq.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.dow = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> apU() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = g.aqe().aqg().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.Lr() != EmotionGroupType.BIG_EMOTION || this.dov) {
                if (next.Lr() != EmotionGroupType.USER_COLLECT || this.dow) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.dos = g.aqe().aqg();
        if (!this.dov || !this.dow) {
            this.dot = apU();
            if (!this.dow && this.dos != null) {
                this.dos = new ArrayList<>(g.aqe().aqg());
                int i = 0;
                while (true) {
                    if (i < this.dos.size()) {
                        if (this.dos.get(i).Lr() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.dos.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.dot = g.aqe().aqg();
        }
        if ((this.dos == null || this.dos.size() <= 0) && this.dox < 3) {
            this.dox++;
            g.aqe().aqf();
            return;
        }
        this.doq.setDatas(this.dos);
        int size = this.dos.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.dos.get(i3);
            if (this.dou != null && this.dou.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.aJC);
        MessageManager.getInstance().registerListener(this.doy);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.aJC);
        MessageManager.getInstance().unRegisterListener(this.doy);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.bfL) {
            this.bfL = skinType;
            onChangeSkinType(this.bfL);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.doq.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.dot.size() && i != this.bvs) {
            this.dop.l(this.dot, i);
            this.doq.setCurrentTab(i);
            this.bvs = i;
            this.dou = this.dot.get(i).getGroupId();
        }
    }

    public void reset() {
        this.bvs = -1;
        this.dos.clear();
        this.dop.reset();
        this.doq.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.dov = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void hT(int i) {
        if (i >= 0 && i < this.dos.size() && i != this.bvs && this.dop != null) {
            this.dop.md(i);
            this.bvs = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        this.doq.onChangeSkinType(i);
        this.dop.onChangeSkinType(i);
        aj.g(this.dor, d.C0140d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void me(int i) {
        if (this.doq != null && i != this.bvs) {
            this.doq.setCurrentTab(i);
            this.bvs = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dot.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.Lq()) {
                                    arrayList.add(next);
                                }
                            }
                            this.dop.l(arrayList, 0);
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
        this.axP = iVar;
        this.dop.setOnDataSelected(iVar);
        this.doq.setOnDataSelected(iVar);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axP != null) {
            this.axP.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axQ = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axQ;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.s
    public void th() {
        if (this.doq != null) {
            int size = this.dos.size();
            for (int i = 0; i < size; i++) {
                this.doq.C(i, this.dov);
            }
            this.doq.setTabWidgetBigEmontionVisibility(this.dov);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }
}
