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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements n, EmotionTabContentView.b, EmotionTabWidgetView.a {
    private EditorTools acX;
    private int acY;
    private int akf;
    private int bHL;
    private CustomMessageListener eHt;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> iAA;
    private String iAB;
    private boolean iAC;
    private boolean iAD;
    private int iAE;
    private CustomMessageListener iAF;
    private EmotionTabContentView iAw;
    private EmotionTabWidgetView iAx;
    private View iAy;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> iAz;

    public EmotionTabHost(Context context) {
        super(context);
        this.iAz = new ArrayList<>();
        this.iAA = new ArrayList<>();
        this.bHL = -1;
        this.iAB = null;
        this.akf = -1;
        this.iAC = true;
        this.iAD = true;
        this.iAE = 0;
        this.acY = 0;
        this.eHt = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.iAF = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.iAz.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.iAz.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.iAz.get(i2)).bBj() != EmotionGroupType.USER_COLLECT) {
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
        this.iAz = new ArrayList<>();
        this.iAA = new ArrayList<>();
        this.bHL = -1;
        this.iAB = null;
        this.akf = -1;
        this.iAC = true;
        this.iAD = true;
        this.iAE = 0;
        this.acY = 0;
        this.eHt = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.iAF = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.iAz.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.iAz.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.iAz.get(i2)).bBj() != EmotionGroupType.USER_COLLECT) {
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
        this.iAw = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.iAx = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.iAy = findViewById(R.id.emotion_tab_widget_div_line);
        this.iAx.setOnTabSelectedListener(this);
        this.iAw.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.akf = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.akf);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.iAx != null) {
            this.iAx.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.iAD = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cts() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.ctC().ctE().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.bBj() != EmotionGroupType.BIG_EMOTION || this.iAC) {
                if (next.bBj() != EmotionGroupType.USER_COLLECT || this.iAD) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.iAz = e.ctC().ctE();
        if (!this.iAC || !this.iAD) {
            this.iAA = cts();
            if (!this.iAD && this.iAz != null) {
                this.iAz = new ArrayList<>(e.ctC().ctE());
                int i = 0;
                while (true) {
                    if (i < this.iAz.size()) {
                        if (this.iAz.get(i).bBj() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.iAz.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.iAA = e.ctC().ctE();
        }
        if ((this.iAz == null || this.iAz.size() <= 0) && this.iAE < 3) {
            this.iAE++;
            e.ctC().ctD();
            return;
        }
        this.iAx.setDatas(this.iAz);
        int size = this.iAz.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.iAz.get(i3);
            if (this.iAB != null && this.iAB.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.eHt);
        MessageManager.getInstance().registerListener(this.iAF);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.eHt);
        MessageManager.getInstance().unRegisterListener(this.iAF);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.akf) {
            this.akf = skinType;
            onChangeSkinType(this.akf);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.iAx.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.iAA.size() && i != this.bHL) {
            this.iAw.g(this.iAA, i);
            this.iAx.setCurrentTab(i);
            this.bHL = i;
            this.iAB = this.iAA.get(i).getGroupId();
        }
    }

    public void reset() {
        this.bHL = -1;
        this.iAz.clear();
        this.iAw.reset();
        this.iAx.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.iAC = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void rd(int i) {
        if (i >= 0 && i < this.iAz.size() && i != this.bHL && this.iAw != null) {
            this.iAw.xf(i);
            this.bHL = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.iAx.onChangeSkinType(i);
        this.iAw.onChangeSkinType(i);
        ao.setBackgroundColor(this.iAy, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void xg(int i) {
        if (this.iAx != null && i != this.bHL) {
            this.iAx.setCurrentTab(i);
            this.bHL = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 1:
                    TiebaStatic.log(new aq("c12612").an("obj_locate", 7));
                    return;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iAA.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.bBi()) {
                                    arrayList.add(next);
                                }
                            }
                            this.iAw.g(arrayList, 0);
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

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acX = editorTools;
        this.iAw.setOnDataSelected(editorTools);
        this.iAx.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acX != null) {
            this.acX.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.acY = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.acY;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.n
    public void rV() {
        if (this.iAx != null) {
            int size = this.iAz.size();
            for (int i = 0; i < size; i++) {
                this.iAx.setTabWidgetVisibility(i, this.iAC);
            }
            this.iAx.setTabWidgetBigEmontionVisibility(this.iAC);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }
}
