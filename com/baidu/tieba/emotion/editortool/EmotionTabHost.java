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
/* loaded from: classes5.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements m, EmotionTabContentView.b, EmotionTabWidgetView.a {
    private EditorTools Fv;
    private int Fw;
    private int MH;
    private CustomMessageListener cHC;
    private EmotionTabContentView fQh;
    private EmotionTabWidgetView fQi;
    private View fQj;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> fQk;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> fQl;
    private String fQm;
    private boolean fQn;
    private boolean fQo;
    private int fQp;
    private CustomMessageListener fQq;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.fQk = new ArrayList<>();
        this.fQl = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.fQm = null;
        this.MH = -1;
        this.fQn = true;
        this.fQo = true;
        this.fQp = 0;
        this.Fw = 0;
        this.cHC = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.fQq = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.fQk.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.fQk.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.fQk.get(i2)).aMk() != EmotionGroupType.USER_COLLECT) {
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
        this.fQk = new ArrayList<>();
        this.fQl = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.fQm = null;
        this.MH = -1;
        this.fQn = true;
        this.fQo = true;
        this.fQp = 0;
        this.Fw = 0;
        this.cHC = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.fQq = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.fQk.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.fQk.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.fQk.get(i2)).aMk() != EmotionGroupType.USER_COLLECT) {
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
        this.fQh = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.fQi = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.fQj = findViewById(R.id.emotion_tab_widget_div_line);
        this.fQi.setOnTabSelectedListener(this);
        this.fQh.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.MH = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.MH);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.fQi != null) {
            this.fQi.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.fQo = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bvJ() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.bvT().bvV().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.aMk() != EmotionGroupType.BIG_EMOTION || this.fQn) {
                if (next.aMk() != EmotionGroupType.USER_COLLECT || this.fQo) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.fQk = e.bvT().bvV();
        if (!this.fQn || !this.fQo) {
            this.fQl = bvJ();
            if (!this.fQo && this.fQk != null) {
                this.fQk = new ArrayList<>(e.bvT().bvV());
                int i = 0;
                while (true) {
                    if (i < this.fQk.size()) {
                        if (this.fQk.get(i).aMk() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.fQk.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.fQl = e.bvT().bvV();
        }
        if ((this.fQk == null || this.fQk.size() <= 0) && this.fQp < 3) {
            this.fQp++;
            e.bvT().bvU();
            return;
        }
        this.fQi.setDatas(this.fQk);
        int size = this.fQk.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.fQk.get(i3);
            if (this.fQm != null && this.fQm.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cHC);
        MessageManager.getInstance().registerListener(this.fQq);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.cHC);
        MessageManager.getInstance().unRegisterListener(this.fQq);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.MH) {
            this.MH = skinType;
            onChangeSkinType(this.MH);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.fQi.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.fQl.size() && i != this.mCurrentIndex) {
            this.fQh.f(this.fQl, i);
            this.fQi.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.fQm = this.fQl.get(i).getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.fQk.clear();
        this.fQh.reset();
        this.fQi.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.fQn = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void mi(int i) {
        if (i >= 0 && i < this.fQk.size() && i != this.mCurrentIndex && this.fQh != null) {
            this.fQh.rv(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        this.fQi.onChangeSkinType(i);
        this.fQh.onChangeSkinType(i);
        am.setBackgroundColor(this.fQj, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void rw(int i) {
        if (this.fQi != null && i != this.mCurrentIndex) {
            this.fQi.setCurrentTab(i);
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.fQl.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.aMj()) {
                                    arrayList.add(next);
                                }
                            }
                            this.fQh.f(arrayList, 0);
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
        this.Fv = editorTools;
        this.fQh.setOnDataSelected(editorTools);
        this.fQi.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Fv != null) {
            this.Fv.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Fw = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Fw;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.fQi != null) {
            int size = this.fQk.size();
            for (int i = 0; i < size; i++) {
                this.fQi.setTabWidgetVisibility(i, this.fQn);
            }
            this.fQi.setTabWidgetBigEmontionVisibility(this.fQn);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }
}
