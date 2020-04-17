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
/* loaded from: classes6.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements m, EmotionTabContentView.b, EmotionTabWidgetView.a {
    private EditorTools Za;
    private int Zb;
    private int afT;
    private CustomMessageListener dkZ;
    private EmotionTabContentView gyi;
    private EmotionTabWidgetView gyj;
    private View gyk;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> gyl;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> gym;
    private String gyn;
    private boolean gyo;
    private boolean gyp;
    private int gyq;
    private CustomMessageListener gyr;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.gyl = new ArrayList<>();
        this.gym = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.gyn = null;
        this.afT = -1;
        this.gyo = true;
        this.gyp = true;
        this.gyq = 0;
        this.Zb = 0;
        this.dkZ = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.gyr = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.gyl.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.gyl.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.gyl.get(i2)).aXe() != EmotionGroupType.USER_COLLECT) {
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
        this.gyl = new ArrayList<>();
        this.gym = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.gyn = null;
        this.afT = -1;
        this.gyo = true;
        this.gyp = true;
        this.gyq = 0;
        this.Zb = 0;
        this.dkZ = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.gyr = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.gyl.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.gyl.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.gyl.get(i2)).aXe() != EmotionGroupType.USER_COLLECT) {
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
        this.gyi = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.gyj = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.gyk = findViewById(R.id.emotion_tab_widget_div_line);
        this.gyj.setOnTabSelectedListener(this);
        this.gyi.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.afT = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.afT);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.gyj != null) {
            this.gyj.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.gyp = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bHh() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.bHr().bHt().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.aXe() != EmotionGroupType.BIG_EMOTION || this.gyo) {
                if (next.aXe() != EmotionGroupType.USER_COLLECT || this.gyp) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.gyl = e.bHr().bHt();
        if (!this.gyo || !this.gyp) {
            this.gym = bHh();
            if (!this.gyp && this.gyl != null) {
                this.gyl = new ArrayList<>(e.bHr().bHt());
                int i = 0;
                while (true) {
                    if (i < this.gyl.size()) {
                        if (this.gyl.get(i).aXe() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.gyl.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.gym = e.bHr().bHt();
        }
        if ((this.gyl == null || this.gyl.size() <= 0) && this.gyq < 3) {
            this.gyq++;
            e.bHr().bHs();
            return;
        }
        this.gyj.setDatas(this.gyl);
        int size = this.gyl.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.gyl.get(i3);
            if (this.gyn != null && this.gyn.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dkZ);
        MessageManager.getInstance().registerListener(this.gyr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dkZ);
        MessageManager.getInstance().unRegisterListener(this.gyr);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.afT) {
            this.afT = skinType;
            onChangeSkinType(this.afT);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.gyj.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.gym.size() && i != this.mCurrentIndex) {
            this.gyi.g(this.gym, i);
            this.gyj.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.gyn = this.gym.get(i).getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.gyl.clear();
        this.gyi.reset();
        this.gyj.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.gyo = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void mN(int i) {
        if (i >= 0 && i < this.gyl.size() && i != this.mCurrentIndex && this.gyi != null) {
            this.gyi.rV(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        this.gyj.onChangeSkinType(i);
        this.gyi.onChangeSkinType(i);
        am.setBackgroundColor(this.gyk, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void rW(int i) {
        if (this.gyj != null && i != this.mCurrentIndex) {
            this.gyj.setCurrentTab(i);
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.gym.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.aXd()) {
                                    arrayList.add(next);
                                }
                            }
                            this.gyi.g(arrayList, 0);
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
        this.Za = editorTools;
        this.gyi.setOnDataSelected(editorTools);
        this.gyj.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Za != null) {
            this.Za.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Zb = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Zb;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.gyj != null) {
            int size = this.gyl.size();
            for (int i = 0; i < size; i++) {
                this.gyj.setTabWidgetVisibility(i, this.gyo);
            }
            this.gyj.setTabWidgetBigEmontionVisibility(this.gyo);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }
}
