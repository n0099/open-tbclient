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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements m, EmotionTabContentView.b, EmotionTabWidgetView.a {
    private EditorTools Fq;
    private int Fr;
    private int MA;
    private CustomMessageListener cHq;
    private EmotionTabContentView fMY;
    private EmotionTabWidgetView fMZ;
    private View fNa;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> fNb;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> fNc;
    private String fNd;
    private boolean fNe;
    private boolean fNf;
    private int fNg;
    private CustomMessageListener fNh;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.fNb = new ArrayList<>();
        this.fNc = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.fNd = null;
        this.MA = -1;
        this.fNe = true;
        this.fNf = true;
        this.fNg = 0;
        this.Fr = 0;
        this.cHq = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED /* 2001117 */:
                        EmotionTabHost.this.reset();
                        EmotionTabHost.this.setup();
                        return;
                    default:
                        return;
                }
            }
        };
        this.fNh = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.fNb.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.fNb.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.fNb.get(i2)).aLR() != EmotionGroupType.USER_COLLECT) {
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
        this.fNb = new ArrayList<>();
        this.fNc = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.fNd = null;
        this.MA = -1;
        this.fNe = true;
        this.fNf = true;
        this.fNg = 0;
        this.Fr = 0;
        this.cHq = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED /* 2001117 */:
                        EmotionTabHost.this.reset();
                        EmotionTabHost.this.setup();
                        return;
                    default:
                        return;
                }
            }
        };
        this.fNh = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.fNb.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.fNb.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.fNb.get(i2)).aLR() != EmotionGroupType.USER_COLLECT) {
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
        LayoutInflater.from(context).inflate(R.layout.emotion_tab_host, (ViewGroup) this, true);
        this.fMY = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.fMZ = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.fNa = findViewById(R.id.emotion_tab_widget_div_line);
        this.fMZ.setOnTabSelectedListener(this);
        this.fMY.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.MA = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.MA);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.fMZ != null) {
            this.fMZ.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.fNf = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> buH() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.buR().buT().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.aLR() != EmotionGroupType.BIG_EMOTION || this.fNe) {
                if (next.aLR() != EmotionGroupType.USER_COLLECT || this.fNf) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.fNb = e.buR().buT();
        if (!this.fNe || !this.fNf) {
            this.fNc = buH();
            if (!this.fNf && this.fNb != null) {
                this.fNb = new ArrayList<>(e.buR().buT());
                int i = 0;
                while (true) {
                    if (i < this.fNb.size()) {
                        if (this.fNb.get(i).aLR() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.fNb.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.fNc = e.buR().buT();
        }
        if ((this.fNb == null || this.fNb.size() <= 0) && this.fNg < 3) {
            this.fNg++;
            e.buR().buS();
            return;
        }
        this.fMZ.setDatas(this.fNb);
        int size = this.fNb.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.fNb.get(i3);
            if (this.fNd != null && this.fNd.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cHq);
        MessageManager.getInstance().registerListener(this.fNh);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.cHq);
        MessageManager.getInstance().unRegisterListener(this.fNh);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.MA) {
            this.MA = skinType;
            onChangeSkinType(this.MA);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.fMZ.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.fNc.size() && i != this.mCurrentIndex) {
            this.fMY.f(this.fNc, i);
            this.fMZ.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.fNd = this.fNc.get(i).getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.fNb.clear();
        this.fMY.reset();
        this.fMZ.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.fNe = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void mi(int i) {
        if (i >= 0 && i < this.fNb.size() && i != this.mCurrentIndex && this.fMY != null) {
            this.fMY.rq(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        this.fMZ.onChangeSkinType(i);
        this.fMY.onChangeSkinType(i);
        am.setBackgroundColor(this.fNa, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void rr(int i) {
        if (this.fMZ != null && i != this.mCurrentIndex) {
            this.fMZ.setCurrentTab(i);
            this.mCurrentIndex = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.fNc.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.aLQ()) {
                                    arrayList.add(next);
                                }
                            }
                            this.fMY.f(arrayList, 0);
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

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Fq = editorTools;
        this.fMY.setOnDataSelected(editorTools);
        this.fMZ.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Fq != null) {
            this.Fq.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Fr = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Fr;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.m
    public void lw() {
        if (this.fMZ != null) {
            int size = this.fNb.size();
            for (int i = 0; i < size; i++) {
                this.fMZ.setTabWidgetVisibility(i, this.fNe);
            }
            this.fMZ.setTabWidgetBigEmontionVisibility(this.fNe);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }
}
