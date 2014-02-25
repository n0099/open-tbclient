package com.baidu.tieba.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.emotions.WritableEmotionGroup;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHost extends LinearLayout implements y, com.baidu.tieba.im.messageCenter.g {
    private LayoutInflater a;
    private EmotionTabContentView b;
    private EmotionTabWidgetView c;
    private ArrayList<WritableEmotionGroup> d;
    private int e;
    private String f;
    private int g;
    private boolean h;
    private boolean i;

    public EmotionTabHost(Context context) {
        super(context);
        this.d = new ArrayList<>();
        this.e = -1;
        this.f = null;
        this.g = -1;
        this.i = true;
        a(context);
    }

    public EmotionTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new ArrayList<>();
        this.e = -1;
        this.f = null;
        this.g = -1;
        this.i = true;
        a(context);
    }

    private void a(Context context) {
        removeAllViews();
        this.a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.a.inflate(R.layout.emotion_tab_host, (ViewGroup) this, true);
        this.b = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.c = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.c.setOnTabSelectedListener(this);
        setOrientation(1);
        this.g = TiebaApplication.g().al();
        b(this.g);
        b();
    }

    public void setFrom(int i) {
        if (this.c != null) {
            this.c.setFrom(i);
        }
    }

    private void b() {
        this.d = com.baidu.tieba.data.emotions.l.a().d();
        this.c.setDatas(this.d);
        int size = this.d.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            WritableEmotionGroup writableEmotionGroup = this.d.get(i2);
            if (this.f != null && this.f.equals(writableEmotionGroup.e())) {
                i = i2;
            }
            a(writableEmotionGroup);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.tieba.im.messageCenter.e.a().a(-120, this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.tieba.im.messageCenter.e.a().a(this);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int al = TiebaApplication.g().al();
        if (al != this.g) {
            this.g = al;
            b(this.g);
        }
    }

    private void a(WritableEmotionGroup writableEmotionGroup) {
        this.c.a(writableEmotionGroup);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.d.size() && i != this.e) {
            WritableEmotionGroup writableEmotionGroup = this.d.get(i);
            this.b.a(writableEmotionGroup);
            if (this.h) {
                if (writableEmotionGroup.c() == WritableEmotionGroup.EmotionGroupType.LOCAL) {
                    this.c.setShowDelete(true);
                } else {
                    this.c.setShowDelete(false);
                }
            }
            this.c.setCurrentTab(i);
            this.e = i;
            this.f = writableEmotionGroup.e();
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
                this.d.get(i);
                this.c.a(i, z);
            }
        }
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.s sVar) {
        switch (sVar.w()) {
            case -120:
                a();
                b();
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.editortool.y
    public void a(int i) {
        setCurrentEmotionGroup(i);
    }

    public void b(int i) {
        this.c.a(i);
        this.b.a(i);
    }

    public void setOnDataSelected(z zVar) {
        this.b.setOnDataSelected(zVar);
        this.c.setOnDataSelected(zVar);
    }
}
