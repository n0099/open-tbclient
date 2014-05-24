package com.baidu.tieba.im.live.room;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import java.util.List;
/* loaded from: classes.dex */
public class an extends RelativeLayout {
    private Activity a;
    private LayoutInflater b;
    private TextView c;
    private ImageView d;
    private UserPhotoLayout e;
    private List<MetaData> f;
    private int g;
    private View h;

    public an(Context context) {
        super(context);
        this.f = null;
        this.g = 0;
        a(context);
    }

    public View getRoot() {
        return this.h;
    }

    private void a(Context context) {
        this.a = (Activity) context;
        this.b = (LayoutInflater) context.getSystemService("layout_inflater");
        View inflate = this.b.inflate(com.baidu.tieba.w.live_room_chat_like, (ViewGroup) this, true);
        this.h = inflate.findViewById(com.baidu.tieba.v.chat_like_layout);
        this.c = (TextView) inflate.findViewById(com.baidu.tieba.v.tvlike);
        this.d = (ImageView) inflate.findViewById(com.baidu.tieba.v.ivlike);
        this.e = (UserPhotoLayout) inflate.findViewById(com.baidu.tieba.v.horizontalScrollView);
        this.e.setAutoChangeStyle(false);
        this.e.setOnChildClickListener(new ao(this));
    }

    public List<MetaData> getMetaData() {
        return this.f;
    }

    public void a(List<MetaData> list, int i) {
        if (this.f != list || this.g != i) {
            this.f = list;
            this.g = i;
            a(true);
        }
    }

    private void a(boolean z) {
        String valueOf = String.valueOf(this.g);
        if (this.g > 999) {
            valueOf = "999+";
        }
        this.c.setText(valueOf);
        this.e.a(this.f, z);
    }

    public ImageView getIvLike() {
        return this.d;
    }

    public TextView getTvLike() {
        return this.c;
    }
}
