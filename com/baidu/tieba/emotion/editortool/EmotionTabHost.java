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
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements l, EmotionTabContentView.b, EmotionTabWidgetView.a {
    private EditorTools Dl;
    private int Dm;
    private int apR;
    private CustomMessageListener bVR;
    private int csX;
    private EmotionTabContentView eZh;
    private EmotionTabWidgetView eZi;
    private View eZj;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eZk;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eZl;
    private String eZm;
    private boolean eZn;
    private boolean eZo;
    private int eZp;
    private CustomMessageListener eZq;

    public EmotionTabHost(Context context) {
        super(context);
        this.eZk = new ArrayList<>();
        this.eZl = new ArrayList<>();
        this.apR = -1;
        this.eZm = null;
        this.csX = -1;
        this.eZn = true;
        this.eZo = true;
        this.eZp = 0;
        this.Dm = 0;
        this.bVR = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.eZq = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.eZk.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.eZk.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.eZk.get(i2)).auo() != EmotionGroupType.USER_COLLECT) {
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
        this.eZk = new ArrayList<>();
        this.eZl = new ArrayList<>();
        this.apR = -1;
        this.eZm = null;
        this.csX = -1;
        this.eZn = true;
        this.eZo = true;
        this.eZp = 0;
        this.Dm = 0;
        this.bVR = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.eZq = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.eZk.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.eZk.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.eZk.get(i2)).auo() != EmotionGroupType.USER_COLLECT) {
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
        this.eZh = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.eZi = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.eZj = findViewById(R.id.emotion_tab_widget_div_line);
        this.eZi.setOnTabSelectedListener(this);
        this.eZh.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.csX = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.csX);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.eZi != null) {
            this.eZi.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.eZo = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bdn() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.bdx().bdz().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.auo() != EmotionGroupType.BIG_EMOTION || this.eZn) {
                if (next.auo() != EmotionGroupType.USER_COLLECT || this.eZo) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.eZk = e.bdx().bdz();
        if (!this.eZn || !this.eZo) {
            this.eZl = bdn();
            if (!this.eZo && this.eZk != null) {
                this.eZk = new ArrayList<>(e.bdx().bdz());
                int i = 0;
                while (true) {
                    if (i < this.eZk.size()) {
                        if (this.eZk.get(i).auo() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.eZk.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.eZl = e.bdx().bdz();
        }
        if ((this.eZk == null || this.eZk.size() <= 0) && this.eZp < 3) {
            this.eZp++;
            e.bdx().bdy();
            return;
        }
        this.eZi.setDatas(this.eZk);
        int size = this.eZk.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.eZk.get(i3);
            if (this.eZm != null && this.eZm.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bVR);
        MessageManager.getInstance().registerListener(this.eZq);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bVR);
        MessageManager.getInstance().unRegisterListener(this.eZq);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.csX) {
            this.csX = skinType;
            onChangeSkinType(this.csX);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eZi.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.eZl.size() && i != this.apR) {
            this.eZh.f(this.eZl, i);
            this.eZi.setCurrentTab(i);
            this.apR = i;
            this.eZm = this.eZl.get(i).getGroupId();
        }
    }

    public void reset() {
        this.apR = -1;
        this.eZk.clear();
        this.eZh.reset();
        this.eZi.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.eZn = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void jW(int i) {
        if (i >= 0 && i < this.eZk.size() && i != this.apR && this.eZh != null) {
            this.eZh.pk(i);
            this.apR = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.eZi.onChangeSkinType(i);
        this.eZh.onChangeSkinType(i);
        am.setBackgroundColor(this.eZj, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void pl(int i) {
        if (this.eZi != null && i != this.apR) {
            this.eZi.setCurrentTab(i);
            this.apR = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eZl.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.aun()) {
                                    arrayList.add(next);
                                }
                            }
                            this.eZh.f(arrayList, 0);
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
        this.Dl = editorTools;
        this.eZh.setOnDataSelected(editorTools);
        this.eZi.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Dl != null) {
            this.Dl.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Dm = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Dm;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.l
    public void le() {
        if (this.eZi != null) {
            int size = this.eZk.size();
            for (int i = 0; i < size; i++) {
                this.eZi.setTabWidgetVisibility(i, this.eZn);
            }
            this.eZi.setTabWidgetBigEmontionVisibility(this.eZn);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }
}
