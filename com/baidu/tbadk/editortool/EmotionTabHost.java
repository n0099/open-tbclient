package com.baidu.tbadk.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbadkApplication;
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
    private com.baidu.adp.framework.c.a j;

    public EmotionTabHost(Context context) {
        super(context);
        this.d = new ArrayList<>();
        this.e = -1;
        this.f = null;
        this.g = -1;
        this.i = true;
        this.j = new s(this, 2001120);
        a(context);
    }

    public EmotionTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new ArrayList<>();
        this.e = -1;
        this.f = null;
        this.g = -1;
        this.i = true;
        this.j = new s(this, 2001120);
        a(context);
    }

    private void a(Context context) {
        removeAllViews();
        this.a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.a.inflate(com.baidu.tbadk.k.emotion_tab_host, (ViewGroup) this, true);
        this.b = (EmotionTabContentView) findViewById(com.baidu.tbadk.j.face_tab_content);
        this.c = (EmotionTabWidgetView) findViewById(com.baidu.tbadk.j.face_tab_widget);
        this.c.setOnTabSelectedListener(this);
        setOrientation(1);
        this.g = TbadkApplication.j().l();
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
            this.c.a(agVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.adp.framework.c.a().a(this.j);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.framework.c.a().b(this.j);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int l = TbadkApplication.j().l();
        if (l != this.g) {
            this.g = l;
            b(this.g);
        }
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

    public final void a() {
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
    public final void a(int i) {
        setCurrentEmotionGroup(i);
    }

    public final void b(int i) {
        this.c.a(i);
        this.b.a(i);
    }

    public void setOnDataSelected(x xVar) {
        this.b.setOnDataSelected(xVar);
        this.c.setOnDataSelected(xVar);
    }
}
