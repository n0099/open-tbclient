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
    private EditorTools Zd;
    private int Ze;
    private int afW;
    private CustomMessageListener dld;
    private EmotionTabContentView gyo;
    private EmotionTabWidgetView gyp;
    private View gyq;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> gyr;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> gys;
    private String gyt;
    private boolean gyu;
    private boolean gyv;
    private int gyw;
    private CustomMessageListener gyx;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.gyr = new ArrayList<>();
        this.gys = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.gyt = null;
        this.afW = -1;
        this.gyu = true;
        this.gyv = true;
        this.gyw = 0;
        this.Ze = 0;
        this.dld = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.gyx = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.gyr.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.gyr.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.gyr.get(i2)).aXc() != EmotionGroupType.USER_COLLECT) {
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
        this.gyr = new ArrayList<>();
        this.gys = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.gyt = null;
        this.afW = -1;
        this.gyu = true;
        this.gyv = true;
        this.gyw = 0;
        this.Ze = 0;
        this.dld = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.gyx = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.gyr.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.gyr.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.gyr.get(i2)).aXc() != EmotionGroupType.USER_COLLECT) {
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
        this.gyo = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.gyp = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.gyq = findViewById(R.id.emotion_tab_widget_div_line);
        this.gyp.setOnTabSelectedListener(this);
        this.gyo.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.afW = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.afW);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.gyp != null) {
            this.gyp.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.gyv = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bHg() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.bHq().bHs().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.aXc() != EmotionGroupType.BIG_EMOTION || this.gyu) {
                if (next.aXc() != EmotionGroupType.USER_COLLECT || this.gyv) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.gyr = e.bHq().bHs();
        if (!this.gyu || !this.gyv) {
            this.gys = bHg();
            if (!this.gyv && this.gyr != null) {
                this.gyr = new ArrayList<>(e.bHq().bHs());
                int i = 0;
                while (true) {
                    if (i < this.gyr.size()) {
                        if (this.gyr.get(i).aXc() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.gyr.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.gys = e.bHq().bHs();
        }
        if ((this.gyr == null || this.gyr.size() <= 0) && this.gyw < 3) {
            this.gyw++;
            e.bHq().bHr();
            return;
        }
        this.gyp.setDatas(this.gyr);
        int size = this.gyr.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.gyr.get(i3);
            if (this.gyt != null && this.gyt.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dld);
        MessageManager.getInstance().registerListener(this.gyx);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dld);
        MessageManager.getInstance().unRegisterListener(this.gyx);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.afW) {
            this.afW = skinType;
            onChangeSkinType(this.afW);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.gyp.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.gys.size() && i != this.mCurrentIndex) {
            this.gyo.g(this.gys, i);
            this.gyp.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.gyt = this.gys.get(i).getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.gyr.clear();
        this.gyo.reset();
        this.gyp.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.gyu = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void mN(int i) {
        if (i >= 0 && i < this.gyr.size() && i != this.mCurrentIndex && this.gyo != null) {
            this.gyo.rV(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        this.gyp.onChangeSkinType(i);
        this.gyo.onChangeSkinType(i);
        am.setBackgroundColor(this.gyq, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void rW(int i) {
        if (this.gyp != null && i != this.mCurrentIndex) {
            this.gyp.setCurrentTab(i);
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.gys.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.aXb()) {
                                    arrayList.add(next);
                                }
                            }
                            this.gyo.g(arrayList, 0);
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
        this.Zd = editorTools;
        this.gyo.setOnDataSelected(editorTools);
        this.gyp.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Zd != null) {
            this.Zd.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Ze = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Ze;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.gyp != null) {
            int size = this.gyr.size();
            for (int i = 0; i < size; i++) {
                this.gyp.setTabWidgetVisibility(i, this.gyu);
            }
            this.gyp.setTabWidgetBigEmontionVisibility(this.gyu);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }
}
