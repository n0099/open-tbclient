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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
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
    private CustomMessageListener aIf;
    private i axN;
    private int axO;
    private int bdK;
    private int bsW;
    private EmotionTabContentView dld;
    private EmotionTabWidgetView dle;
    private View dlf;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dlg;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dlh;
    private String dli;
    private boolean dlj;
    private boolean dlk;
    private int dll;
    private CustomMessageListener dlm;

    public b(Context context) {
        super(context);
        this.dlg = new ArrayList<>();
        this.dlh = new ArrayList<>();
        this.bsW = -1;
        this.dli = null;
        this.bdK = -1;
        this.dlj = true;
        this.dlk = true;
        this.dll = 0;
        this.axO = 0;
        this.aIf = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED /* 2001117 */:
                        b.this.reset();
                        b.this.setup();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dlm = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && b.this.dlg.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < b.this.dlg.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) b.this.dlg.get(i2)).KJ() != EmotionGroupType.USER_COLLECT) {
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
        this.dld = (EmotionTabContentView) findViewById(d.g.face_tab_content);
        this.dle = (EmotionTabWidgetView) findViewById(d.g.face_tab_widget);
        this.dlf = findViewById(d.g.emotion_tab_widget_div_line);
        this.dle.setOnTabSelectedListener(this);
        this.dld.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.bdK = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.bdK);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.dle != null) {
            this.dle.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.dlk = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> apa() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = g.apk().apm().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.KJ() != EmotionGroupType.BIG_EMOTION || this.dlj) {
                if (next.KJ() != EmotionGroupType.USER_COLLECT || this.dlk) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.dlg = g.apk().apm();
        if (!this.dlj || !this.dlk) {
            this.dlh = apa();
            if (!this.dlk && this.dlg != null) {
                this.dlg = new ArrayList<>(g.apk().apm());
                int i = 0;
                while (true) {
                    if (i < this.dlg.size()) {
                        if (this.dlg.get(i).KJ() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.dlg.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.dlh = g.apk().apm();
        }
        if ((this.dlg == null || this.dlg.size() <= 0) && this.dll < 3) {
            this.dll++;
            g.apk().apl();
            return;
        }
        this.dle.setDatas(this.dlg);
        int size = this.dlg.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.dlg.get(i3);
            if (this.dli != null && this.dli.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.aIf);
        MessageManager.getInstance().registerListener(this.dlm);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.aIf);
        MessageManager.getInstance().unRegisterListener(this.dlm);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.bdK) {
            this.bdK = skinType;
            onChangeSkinType(this.bdK);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.dle.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.dlh.size() && i != this.bsW) {
            this.dld.l(this.dlh, i);
            this.dle.setCurrentTab(i);
            this.bsW = i;
            this.dli = this.dlh.get(i).getGroupId();
        }
    }

    public void reset() {
        this.bsW = -1;
        this.dlg.clear();
        this.dld.reset();
        this.dle.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.dlj = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void hV(int i) {
        if (i >= 0 && i < this.dlg.size() && i != this.bsW && this.dld != null) {
            this.dld.mg(i);
            this.bsW = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        this.dle.onChangeSkinType(i);
        this.dld.onChangeSkinType(i);
        aj.g(this.dlf, d.C0107d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void mh(int i) {
        if (this.dle != null && i != this.bsW) {
            this.dle.setCurrentTab(i);
            this.bsW = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dlh.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.KI()) {
                                    arrayList.add(next);
                                }
                            }
                            this.dld.l(arrayList, 0);
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
        this.axN = iVar;
        this.dld.setOnDataSelected(iVar);
        this.dle.setOnDataSelected(iVar);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axN != null) {
            this.axN.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axO = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axO;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.s
    public void th() {
        if (this.dle != null) {
            int size = this.dlg.size();
            for (int i = 0; i < size; i++) {
                this.dle.y(i, this.dlj);
            }
            this.dle.setTabWidgetBigEmontionVisibility(this.dlj);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }
}
