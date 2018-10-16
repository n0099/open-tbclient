package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.e;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements l, EmotionTabContentView.b, EmotionTabWidgetView.a {
    private EditorTools SY;
    private int SZ;
    private int aHp;
    private int aWO;
    private CustomMessageListener ajQ;
    private EmotionTabContentView dfi;
    private EmotionTabWidgetView dfj;
    private View dfk;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dfl;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dfm;
    private String dfn;
    private boolean dfo;
    private boolean dfp;
    private int dfq;
    private CustomMessageListener dfr;

    public EmotionTabHost(Context context) {
        super(context);
        this.dfl = new ArrayList<>();
        this.dfm = new ArrayList<>();
        this.aWO = -1;
        this.dfn = null;
        this.aHp = -1;
        this.dfo = true;
        this.dfp = true;
        this.dfq = 0;
        this.SZ = 0;
        this.ajQ = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                switch (customResponsedMessage.getCmd()) {
                    case 2001117:
                        EmotionTabHost.this.reset();
                        EmotionTabHost.this.setup();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dfr = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.dfl.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.dfl.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.dfl.get(i2)).KW() != EmotionGroupType.USER_COLLECT) {
                                i = i2 + 1;
                            } else {
                                EmotionTabHost.this.setCurrentEmotionGroup(i2);
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

    public EmotionTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dfl = new ArrayList<>();
        this.dfm = new ArrayList<>();
        this.aWO = -1;
        this.dfn = null;
        this.aHp = -1;
        this.dfo = true;
        this.dfp = true;
        this.dfq = 0;
        this.SZ = 0;
        this.ajQ = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                switch (customResponsedMessage.getCmd()) {
                    case 2001117:
                        EmotionTabHost.this.reset();
                        EmotionTabHost.this.setup();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dfr = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.dfl.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.dfl.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.dfl.get(i2)).KW() != EmotionGroupType.USER_COLLECT) {
                                i = i2 + 1;
                            } else {
                                EmotionTabHost.this.setCurrentEmotionGroup(i2);
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
        LayoutInflater.from(context).inflate(e.h.emotion_tab_host, (ViewGroup) this, true);
        this.dfi = (EmotionTabContentView) findViewById(e.g.face_tab_content);
        this.dfj = (EmotionTabWidgetView) findViewById(e.g.face_tab_widget);
        this.dfk = findViewById(e.g.emotion_tab_widget_div_line);
        this.dfj.setOnTabSelectedListener(this);
        this.dfi.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aHp = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.aHp);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.dfj != null) {
            this.dfj.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.dfp = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> atm() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.atw().aty().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.KW() != EmotionGroupType.BIG_EMOTION || this.dfo) {
                if (next.KW() != EmotionGroupType.USER_COLLECT || this.dfp) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.dfl = e.atw().aty();
        if (!this.dfo || !this.dfp) {
            this.dfm = atm();
            if (!this.dfp && this.dfl != null) {
                this.dfl = new ArrayList<>(e.atw().aty());
                int i = 0;
                while (true) {
                    if (i < this.dfl.size()) {
                        if (this.dfl.get(i).KW() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.dfl.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.dfm = e.atw().aty();
        }
        if ((this.dfl == null || this.dfl.size() <= 0) && this.dfq < 3) {
            this.dfq++;
            e.atw().atx();
            return;
        }
        this.dfj.setDatas(this.dfl);
        int size = this.dfl.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.dfl.get(i3);
            if (this.dfn != null && this.dfn.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.ajQ);
        MessageManager.getInstance().registerListener(this.dfr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.ajQ);
        MessageManager.getInstance().unRegisterListener(this.dfr);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aHp) {
            this.aHp = skinType;
            onChangeSkinType(this.aHp);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.dfj.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.dfm.size() && i != this.aWO) {
            this.dfi.j(this.dfm, i);
            this.dfj.setCurrentTab(i);
            this.aWO = i;
            this.dfn = this.dfm.get(i).getGroupId();
        }
    }

    public void reset() {
        this.aWO = -1;
        this.dfl.clear();
        this.dfi.reset();
        this.dfj.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.dfo = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void ft(int i) {
        if (i >= 0 && i < this.dfl.size() && i != this.aWO && this.dfi != null) {
            this.dfi.kw(i);
            this.aWO = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.dfj.onChangeSkinType(i);
        this.dfi.onChangeSkinType(i);
        al.e(this.dfk, e.d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void kx(int i) {
        if (this.dfj != null && i != this.aWO) {
            this.dfj.setCurrentTab(i);
            this.aWO = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dfm.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.KV()) {
                                    arrayList.add(next);
                                }
                            }
                            this.dfi.j(arrayList, 0);
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

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.SY = editorTools;
        this.dfi.setOnDataSelected(editorTools);
        this.dfj.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.SY != null) {
            this.SY.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.SZ = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.SZ;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pQ() {
        if (this.dfj != null) {
            int size = this.dfl.size();
            for (int i = 0; i < size; i++) {
                this.dfj.setTabWidgetVisibility(i, this.dfo);
            }
            this.dfj.setTabWidgetBigEmontionVisibility(this.dfo);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }
}
