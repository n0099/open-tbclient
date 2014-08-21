package com.baidu.tbadk.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHost extends LinearLayout implements t {
    private EmotionTabContentView a;
    private EmotionTabWidgetView b;
    private ArrayList<ad> c;
    private int d;
    private String e;
    private int f;
    private boolean g;
    private boolean h;
    private CustomMessageListener i;

    public EmotionTabHost(Context context) {
        super(context);
        this.c = new ArrayList<>();
        this.d = -1;
        this.e = null;
        this.f = -1;
        this.h = true;
        this.i = new r(this, 2001120);
        a(context);
    }

    public EmotionTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new ArrayList<>();
        this.d = -1;
        this.e = null;
        this.f = -1;
        this.h = true;
        this.i = new r(this, 2001120);
        a(context);
    }

    private void a(Context context) {
        removeAllViews();
        com.baidu.adp.lib.e.b.a().a(context, com.baidu.tieba.v.emotion_tab_host, this, true);
        this.a = (EmotionTabContentView) findViewById(com.baidu.tieba.u.face_tab_content);
        this.b = (EmotionTabWidgetView) findViewById(com.baidu.tieba.u.face_tab_widget);
        this.b.setOnTabSelectedListener(this);
        setOrientation(1);
        this.f = TbadkApplication.m252getInst().getSkinType();
        b(this.f);
        b();
    }

    public void setFrom(int i) {
        if (this.b != null) {
            this.b.setFrom(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.c = aa.a().c();
        this.b.setDatas(this.c);
        int size = this.c.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            ad adVar = this.c.get(i2);
            if (this.e != null && this.e.equals(adVar.e())) {
                i = i2;
            }
            a(adVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.i);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (skinType != this.f) {
            this.f = skinType;
            b(this.f);
        }
    }

    private void a(ad adVar) {
        this.b.a(adVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.c.size() && i != this.d) {
            ad adVar = this.c.get(i);
            this.a.a(adVar);
            if (this.g) {
                if (adVar.c() == EmotionGroupType.LOCAL) {
                    this.b.setShowDelete(true);
                } else {
                    this.b.setShowDelete(false);
                }
            }
            this.b.setCurrentTab(i);
            this.d = i;
            this.e = adVar.e();
        }
    }

    public void a() {
        this.d = -1;
        this.c.clear();
        this.a.a();
        this.b.a();
    }

    public void setIsInChat(boolean z) {
        this.g = z;
    }

    public void setShowBigEmotion(boolean z) {
        this.h = z;
        if (!this.h) {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                this.b.a(i, z);
            }
        }
    }

    @Override // com.baidu.tbadk.editortool.t
    public void a(int i) {
        setCurrentEmotionGroup(i);
    }

    public void b(int i) {
        this.b.a(i);
        this.a.a(i);
    }

    public void setOnDataSelected(w wVar) {
        this.a.setOnDataSelected(wVar);
        this.b.setOnDataSelected(wVar);
    }
}
