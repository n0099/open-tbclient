package com.baidu.tbadk.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHost extends LinearLayout implements u {
    private LayoutInflater a;
    private EmotionTabContentView b;
    private EmotionTabWidgetView c;
    private ArrayList<ag> d;
    private int e;
    private String f;
    private int g;
    private boolean h;
    private boolean i;
    private CustomMessageListener j;

    public EmotionTabHost(Context context) {
        super(context);
        this.d = new ArrayList<>();
        this.e = -1;
        this.f = null;
        this.g = -1;
        this.i = true;
        this.j = new s(this, MessageTypes.CMD_EMOTIONS_GROUP_CHANGED);
        a(context);
    }

    public EmotionTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new ArrayList<>();
        this.e = -1;
        this.f = null;
        this.g = -1;
        this.i = true;
        this.j = new s(this, MessageTypes.CMD_EMOTIONS_GROUP_CHANGED);
        a(context);
    }

    private void a(Context context) {
        removeAllViews();
        this.a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.a.inflate(com.baidu.tieba.s.emotion_tab_host, (ViewGroup) this, true);
        this.b = (EmotionTabContentView) findViewById(com.baidu.tieba.r.face_tab_content);
        this.c = (EmotionTabWidgetView) findViewById(com.baidu.tieba.r.face_tab_widget);
        this.c.setOnTabSelectedListener(this);
        setOrientation(1);
        this.g = TbadkApplication.m252getInst().getSkinType();
        b(this.g);
        b();
    }

    public void setFrom(int i) {
        if (this.c != null) {
            this.c.setFrom(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.d = ac.a().d();
        this.c.setDatas(this.d);
        int size = this.d.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            ag agVar = this.d.get(i2);
            if (this.f != null && this.f.equals(agVar.e())) {
                i = i2;
            }
            a(agVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.j);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.j);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (skinType != this.g) {
            this.g = skinType;
            b(this.g);
        }
    }

    private void a(ag agVar) {
        this.c.a(agVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.d.size() && i != this.e) {
            ag agVar = this.d.get(i);
            this.b.a(agVar);
            if (this.h) {
                if (agVar.c() == EmotionGroupType.LOCAL) {
                    this.c.setShowDelete(true);
                } else {
                    this.c.setShowDelete(false);
                }
            }
            this.c.setCurrentTab(i);
            this.e = i;
            this.f = agVar.e();
        }
    }

    public void a() {
        this.e = -1;
        this.d.clear();
        this.b.a();
        this.c.a();
    }

    public void setIsInChat(boolean z) {
        this.h = z;
    }

    public void setShowBigEmotion(boolean z) {
        this.i = z;
        if (!this.i) {
            int size = this.d.size();
            for (int i = 0; i < size; i++) {
                this.c.a(i, z);
            }
        }
    }

    @Override // com.baidu.tbadk.editortool.u
    public void a(int i) {
        setCurrentEmotionGroup(i);
    }

    public void b(int i) {
        this.c.a(i);
        this.b.a(i);
    }

    public void setOnDataSelected(x xVar) {
        this.b.setOnDataSelected(xVar);
        this.c.setOnDataSelected(xVar);
    }
}
