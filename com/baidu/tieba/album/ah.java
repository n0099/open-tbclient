package com.baidu.tieba.album;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
public final class ah extends com.baidu.tbadk.core.d implements u {
    private AlbumActivity a;
    private p b;
    private e c;
    private View d;
    private NavigationBar e;
    private View f;
    private TextView g;
    private TextView h;
    private GridView i;
    private ab j;
    private View k;
    private String l;
    private List<ImageFileInfo> m;
    private boolean n = true;
    private aa o;
    private z p;
    private boolean q;
    private boolean r;

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = (AlbumActivity) getActivity();
        this.b = this.a.f();
        q.a().a(this);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.d = layoutInflater.inflate(com.baidu.tieba.a.i.album_image_list_view, (ViewGroup) null);
        this.e = (NavigationBar) this.d.findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.f = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.a);
        this.g = this.e.a("");
        this.h = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getString(com.baidu.tieba.a.k.cancel), this.a);
        this.i = (GridView) this.d.findViewById(com.baidu.tieba.a.h.gv_image_list);
        this.j = new ab(this.a, this.b);
        this.i.setAdapter((ListAdapter) this.j);
        this.i.setOnScrollListener(this.j);
        this.o = new ai(this);
        this.p = new aj(this);
        this.j.a(this.o);
        this.j.a(this.p);
        this.k = this.d.findViewById(com.baidu.tieba.a.h.lay_no_data);
        return this.d;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        this.r = false;
        if (isShow()) {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<ImageFileInfo> list) {
        if (this.j != null) {
            this.b.a(list);
            this.j.a(list);
        }
    }

    @Override // com.baidu.tbadk.core.d
    public final void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.b().a(i == 1);
        this.a.b().a(this.d);
        this.e.b(i);
    }

    public final View a() {
        return this.f;
    }

    public final TextView b() {
        return this.h;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        if (this.c != null) {
            this.c.b();
        }
        q.a().b(this);
    }

    public final void a(int i, boolean z) {
        if (this.i != null) {
            int firstVisiblePosition = this.i.getFirstVisiblePosition();
            int lastVisiblePosition = this.i.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.i.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    ImageView imageView = (ImageView) childAt.findViewById(com.baidu.tieba.a.h.select_icon);
                    int l = TbadkApplication.j().l();
                    if (z) {
                        if (l == 1) {
                            imageView.setBackgroundResource(com.baidu.tieba.a.g.btn_choose_photo_s_1);
                        } else {
                            imageView.setBackgroundResource(com.baidu.tieba.a.g.btn_choose_photo_s);
                        }
                    } else if (l == 1) {
                        imageView.setBackgroundResource(com.baidu.tieba.a.g.btn_choose_photo_n_1);
                    } else {
                        imageView.setBackgroundResource(com.baidu.tieba.a.g.btn_choose_photo_n);
                    }
                }
            }
        }
    }

    public final void a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.j != null) {
            a(this.j.a(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onPause() {
        super.onPause();
        this.r = true;
    }

    @Override // com.baidu.tieba.album.u
    public final void a(boolean z) {
        this.q = z;
        this.n = false;
        c();
    }

    private void c() {
        if (!isHidden() && !this.r) {
            if (this.q) {
                this.i.setVisibility(8);
                this.k.setVisibility(0);
                return;
            }
            this.i.setVisibility(0);
            this.k.setVisibility(8);
            if (this.b == null && this.a != null) {
                this.b = this.a.f();
            }
            if (this.b != null) {
                String e = this.b.e();
                if (TextUtils.isEmpty(e)) {
                    e = this.b.c();
                    if (TextUtils.isEmpty(e)) {
                        return;
                    }
                }
                if (!TextUtils.isEmpty(this.l) && this.l.equals(e) && this.n) {
                    if (this.j != null) {
                        this.j.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                a((List<ImageFileInfo>) null);
                if (this.c == null) {
                    this.c = new e(this.a);
                }
                this.c.a(e, new ak(this));
                this.l = e;
            }
        }
    }
}
