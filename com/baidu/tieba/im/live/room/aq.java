package com.baidu.tieba.im.live.room;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import java.util.List;
/* loaded from: classes.dex */
public class aq extends RelativeLayout {
    private Activity a;
    private TextView b;
    private ImageView c;
    private UserPhotoLayout d;
    private List<MetaData> e;
    private int f;
    private View g;

    public aq(Context context) {
        super(context);
        this.e = null;
        this.f = 0;
        a(context);
    }

    public View getRoot() {
        return this.g;
    }

    private void a(Context context) {
        this.a = (Activity) context;
        View a = com.baidu.adp.lib.e.b.a().a(context, com.baidu.tieba.v.live_room_chat_like, this, true);
        this.g = a.findViewById(com.baidu.tieba.u.chat_like_layout);
        this.b = (TextView) a.findViewById(com.baidu.tieba.u.tvlike);
        this.c = (ImageView) a.findViewById(com.baidu.tieba.u.ivlike);
        this.d = (UserPhotoLayout) a.findViewById(com.baidu.tieba.u.horizontalScrollView);
        this.d.setAutoChangeStyle(false);
        this.d.setOnChildClickListener(new ar(this));
    }

    public List<MetaData> getMetaData() {
        return this.e;
    }

    public void a(List<MetaData> list, int i) {
        if (this.e != list || this.f != i) {
            this.e = list;
            this.f = i;
            a(true);
        }
    }

    private void a(boolean z) {
        String valueOf = String.valueOf(this.f);
        if (this.f > 999) {
            valueOf = "999+";
        }
        this.b.setText(valueOf);
        this.d.a(this.e, z);
    }

    public ImageView getIvLike() {
        return this.c;
    }

    public TextView getTvLike() {
        return this.b;
    }
}
