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
    private CustomMessageListener aJr;
    private i axG;
    private int axH;
    private int bfz;
    private int bvf;
    private EmotionTabContentView dod;
    private EmotionTabWidgetView doe;
    private View dof;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dog;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> doh;
    private String doi;
    private boolean doj;
    private boolean dok;
    private int dol;
    private CustomMessageListener dom;

    public b(Context context) {
        super(context);
        this.dog = new ArrayList<>();
        this.doh = new ArrayList<>();
        this.bvf = -1;
        this.doi = null;
        this.bfz = -1;
        this.doj = true;
        this.dok = true;
        this.dol = 0;
        this.axH = 0;
        this.aJr = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.b.1
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
        this.dom = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && b.this.dog.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < b.this.dog.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) b.this.dog.get(i2)).Lq() != EmotionGroupType.USER_COLLECT) {
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
        this.dod = (EmotionTabContentView) findViewById(d.g.face_tab_content);
        this.doe = (EmotionTabWidgetView) findViewById(d.g.face_tab_widget);
        this.dof = findViewById(d.g.emotion_tab_widget_div_line);
        this.doe.setOnTabSelectedListener(this);
        this.dod.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.bfz = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.bfz);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.doe != null) {
            this.doe.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.dok = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> apT() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = g.aqd().aqf().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.Lq() != EmotionGroupType.BIG_EMOTION || this.doj) {
                if (next.Lq() != EmotionGroupType.USER_COLLECT || this.dok) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.dog = g.aqd().aqf();
        if (!this.doj || !this.dok) {
            this.doh = apT();
            if (!this.dok && this.dog != null) {
                this.dog = new ArrayList<>(g.aqd().aqf());
                int i = 0;
                while (true) {
                    if (i < this.dog.size()) {
                        if (this.dog.get(i).Lq() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.dog.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.doh = g.aqd().aqf();
        }
        if ((this.dog == null || this.dog.size() <= 0) && this.dol < 3) {
            this.dol++;
            g.aqd().aqe();
            return;
        }
        this.doe.setDatas(this.dog);
        int size = this.dog.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.dog.get(i3);
            if (this.doi != null && this.doi.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.aJr);
        MessageManager.getInstance().registerListener(this.dom);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.aJr);
        MessageManager.getInstance().unRegisterListener(this.dom);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.bfz) {
            this.bfz = skinType;
            onChangeSkinType(this.bfz);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.doe.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.doh.size() && i != this.bvf) {
            this.dod.l(this.doh, i);
            this.doe.setCurrentTab(i);
            this.bvf = i;
            this.doi = this.doh.get(i).getGroupId();
        }
    }

    public void reset() {
        this.bvf = -1;
        this.dog.clear();
        this.dod.reset();
        this.doe.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.doj = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void hT(int i) {
        if (i >= 0 && i < this.dog.size() && i != this.bvf && this.dod != null) {
            this.dod.md(i);
            this.bvf = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        this.doe.onChangeSkinType(i);
        this.dod.onChangeSkinType(i);
        aj.g(this.dof, d.C0141d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void me(int i) {
        if (this.doe != null && i != this.bvf) {
            this.doe.setCurrentTab(i);
            this.bvf = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.doh.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.Lp()) {
                                    arrayList.add(next);
                                }
                            }
                            this.dod.l(arrayList, 0);
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
        this.axG = iVar;
        this.dod.setOnDataSelected(iVar);
        this.doe.setOnDataSelected(iVar);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axG != null) {
            this.axG.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axH = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axH;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.s
    public void th() {
        if (this.doe != null) {
            int size = this.dog.size();
            for (int i = 0; i < size; i++) {
                this.doe.C(i, this.doj);
            }
            this.doe.setTabWidgetBigEmontionVisibility(this.doj);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }
}
