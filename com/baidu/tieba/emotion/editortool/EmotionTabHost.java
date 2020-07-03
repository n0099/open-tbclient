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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
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
    private EditorTools ZX;
    private int ZY;
    private int ahx;
    private CustomMessageListener dFw;
    private EmotionTabContentView haf;
    private EmotionTabWidgetView hag;
    private View hah;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> hai;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> haj;
    private String hak;
    private boolean hal;
    private boolean ham;
    private int han;
    private CustomMessageListener hao;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.hai = new ArrayList<>();
        this.haj = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.hak = null;
        this.ahx = -1;
        this.hal = true;
        this.ham = true;
        this.han = 0;
        this.ZY = 0;
        this.dFw = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.hao = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.hai.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.hai.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.hai.get(i2)).bfq() != EmotionGroupType.USER_COLLECT) {
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
        this.hai = new ArrayList<>();
        this.haj = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.hak = null;
        this.ahx = -1;
        this.hal = true;
        this.ham = true;
        this.han = 0;
        this.ZY = 0;
        this.dFw = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.hao = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.hai.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.hai.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.hai.get(i2)).bfq() != EmotionGroupType.USER_COLLECT) {
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
        this.haf = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.hag = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.hah = findViewById(R.id.emotion_tab_widget_div_line);
        this.hag.setOnTabSelectedListener(this);
        this.haf.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.ahx = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.ahx);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.hag != null) {
            this.hag.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.ham = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bQG() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.bQQ().bQS().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.bfq() != EmotionGroupType.BIG_EMOTION || this.hal) {
                if (next.bfq() != EmotionGroupType.USER_COLLECT || this.ham) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.hai = e.bQQ().bQS();
        if (!this.hal || !this.ham) {
            this.haj = bQG();
            if (!this.ham && this.hai != null) {
                this.hai = new ArrayList<>(e.bQQ().bQS());
                int i = 0;
                while (true) {
                    if (i < this.hai.size()) {
                        if (this.hai.get(i).bfq() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.hai.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.haj = e.bQQ().bQS();
        }
        if ((this.hai == null || this.hai.size() <= 0) && this.han < 3) {
            this.han++;
            e.bQQ().bQR();
            return;
        }
        this.hag.setDatas(this.hai);
        int size = this.hai.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.hai.get(i3);
            if (this.hak != null && this.hak.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dFw);
        MessageManager.getInstance().registerListener(this.hao);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dFw);
        MessageManager.getInstance().unRegisterListener(this.hao);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.ahx) {
            this.ahx = skinType;
            onChangeSkinType(this.ahx);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.hag.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.haj.size() && i != this.mCurrentIndex) {
            this.haf.i(this.haj, i);
            this.hag.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.hak = this.haj.get(i).getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.hai.clear();
        this.haf.reset();
        this.hag.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.hal = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void nL(int i) {
        if (i >= 0 && i < this.hai.size() && i != this.mCurrentIndex && this.haf != null) {
            this.haf.td(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        this.hag.onChangeSkinType(i);
        this.haf.onChangeSkinType(i);
        an.setBackgroundColor(this.hah, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void te(int i) {
        if (this.hag != null && i != this.mCurrentIndex) {
            this.hag.setCurrentTab(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 1:
                    TiebaStatic.log(new ao("c12612").ag("obj_locate", 7));
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.haj.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.bfp()) {
                                    arrayList.add(next);
                                }
                            }
                            this.haf.i(arrayList, 0);
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
        this.ZX = editorTools;
        this.haf.setOnDataSelected(editorTools);
        this.hag.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.ZX != null) {
            this.ZX.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.ZY = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.ZY;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.hag != null) {
            int size = this.hai.size();
            for (int i = 0; i < size; i++) {
                this.hag.setTabWidgetVisibility(i, this.hal);
            }
            this.hag.setTabWidgetBigEmontionVisibility(this.hal);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }
}
