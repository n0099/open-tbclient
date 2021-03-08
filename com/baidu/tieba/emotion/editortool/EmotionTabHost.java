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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
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
    private EditorTools ael;
    private int aem;
    private int aln;
    private int bMV;
    private CustomMessageListener eLa;
    private EmotionTabContentView iId;
    private EmotionTabWidgetView iIe;
    private View iIf;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> iIg;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> iIh;
    private String iIi;
    private boolean iIj;
    private boolean iIk;
    private int iIl;
    private CustomMessageListener iIm;

    public EmotionTabHost(Context context) {
        super(context);
        this.iIg = new ArrayList<>();
        this.iIh = new ArrayList<>();
        this.bMV = -1;
        this.iIi = null;
        this.aln = -1;
        this.iIj = true;
        this.iIk = true;
        this.iIl = 0;
        this.aem = 0;
        this.eLa = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.iIm = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.iIg.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.iIg.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.iIg.get(i2)).bBE() != EmotionGroupType.USER_COLLECT) {
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
        this.iIg = new ArrayList<>();
        this.iIh = new ArrayList<>();
        this.bMV = -1;
        this.iIi = null;
        this.aln = -1;
        this.iIj = true;
        this.iIk = true;
        this.iIl = 0;
        this.aem = 0;
        this.eLa = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.iIm = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.iIg.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.iIg.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.iIg.get(i2)).bBE() != EmotionGroupType.USER_COLLECT) {
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
        this.iId = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.iIe = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.iIf = findViewById(R.id.emotion_tab_widget_div_line);
        this.iIe.setOnTabSelectedListener(this);
        this.iId.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aln = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.aln);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.iIe != null) {
            this.iIe.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.iIk = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cuR() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.cvb().cvd().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.bBE() != EmotionGroupType.BIG_EMOTION || this.iIj) {
                if (next.bBE() != EmotionGroupType.USER_COLLECT || this.iIk) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.iIg = e.cvb().cvd();
        if (!this.iIj || !this.iIk) {
            this.iIh = cuR();
            if (!this.iIk && this.iIg != null) {
                this.iIg = new ArrayList<>(e.cvb().cvd());
                int i = 0;
                while (true) {
                    if (i < this.iIg.size()) {
                        if (this.iIg.get(i).bBE() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.iIg.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.iIh = e.cvb().cvd();
        }
        if ((this.iIg == null || this.iIg.size() <= 0) && this.iIl < 3) {
            this.iIl++;
            e.cvb().cvc();
            return;
        }
        this.iIe.setDatas(this.iIg);
        int size = this.iIg.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.iIg.get(i3);
            if (this.iIi != null && this.iIi.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.eLa);
        MessageManager.getInstance().registerListener(this.iIm);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.eLa);
        MessageManager.getInstance().unRegisterListener(this.iIm);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aln) {
            this.aln = skinType;
            onChangeSkinType(this.aln);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.iIe.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.iIh.size() && i != this.bMV) {
            this.iId.g(this.iIh, i);
            this.iIe.setCurrentTab(i);
            this.bMV = i;
            this.iIi = this.iIh.get(i).getGroupId();
        }
    }

    public void reset() {
        this.bMV = -1;
        this.iIg.clear();
        this.iId.reset();
        this.iIe.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.iIj = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void rj(int i) {
        if (i >= 0 && i < this.iIg.size() && i != this.bMV && this.iId != null) {
            this.iId.xq(i);
            this.bMV = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.iIe.onChangeSkinType(i);
        this.iId.onChangeSkinType(i);
        ap.setBackgroundColor(this.iIf, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void xr(int i) {
        if (this.iIe != null && i != this.bMV) {
            this.iIe.setCurrentTab(i);
            this.bMV = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 1:
                    TiebaStatic.log(new ar("c12612").aq("obj_locate", 7));
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iIh.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.bBD()) {
                                    arrayList.add(next);
                                }
                            }
                            this.iId.g(arrayList, 0);
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
        this.ael = editorTools;
        this.iId.setOnDataSelected(editorTools);
        this.iIe.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.ael != null) {
            this.ael.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aem = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aem;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.iIe != null) {
            int size = this.iIg.size();
            for (int i = 0; i < size; i++) {
                this.iIe.setTabWidgetVisibility(i, this.iIj);
            }
            this.iIe.setTabWidgetBigEmontionVisibility(this.iIj);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }
}
