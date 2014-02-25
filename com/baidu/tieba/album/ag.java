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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.img.ImageFileInfo;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public class ag extends com.baidu.tieba.j implements t {
    private AlbumActivity b;
    private p c;
    private e d;
    private View e;
    private NavigationBar f;
    private ImageView g;
    private TextView h;
    private TextView i;
    private GridView j;
    private aa k;
    private View l;
    private String m;
    private List<ImageFileInfo> n;
    private boolean o = true;
    private z p;
    private y q;
    private boolean r;

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = (AlbumActivity) getActivity();
        this.c = this.b.f();
        q.a().a(this);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.f = (NavigationBar) this.e.findViewById(R.id.view_navigation_bar);
        this.g = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.b);
        this.h = this.f.a("");
        this.i = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.b.getString(R.string.cancel), this.b);
        this.j = (GridView) this.e.findViewById(R.id.gv_image_list);
        this.k = new aa(this.b, this.c);
        this.j.setAdapter((ListAdapter) this.k);
        this.j.setOnScrollListener(this.k);
        this.p = new ah(this);
        this.q = new ai(this);
        this.k.a(this.p);
        this.k.a(this.q);
        this.l = this.e.findViewById(R.id.lay_no_data);
        return this.e;
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (b()) {
            e();
        }
    }

    private void d() {
        if (this.c == null && this.b != null) {
            this.c = this.b.f();
        }
        if (this.c != null) {
            String e = this.c.e();
            if (TextUtils.isEmpty(e)) {
                e = this.c.c();
                if (TextUtils.isEmpty(e)) {
                    return;
                }
            }
            if (!TextUtils.isEmpty(this.m) && this.m.equals(e) && this.o) {
                if (this.k != null) {
                    this.k.notifyDataSetChanged();
                    return;
                }
                return;
            }
            a((List<ImageFileInfo>) null);
            b(e);
            this.m = e;
        }
    }

    private void b(String str) {
        if (this.d == null) {
            this.d = new e(this.b);
        }
        this.d.a(str, new aj(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<ImageFileInfo> list) {
        if (this.k != null) {
            this.c.a(list);
            this.k.a(list);
        }
    }

    @Override // com.baidu.tieba.j
    public void c(int i) {
        super.c(i);
        this.b.a().a(i == 1);
        this.b.a().a(this.e);
        this.f.c(i);
    }

    public ImageView a() {
        return this.g;
    }

    public TextView c() {
        return this.i;
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.d != null) {
            this.d.b();
        }
        q.a().b(this);
    }

    public void a(int i, boolean z) {
        if (this.j != null) {
            int firstVisiblePosition = this.j.getFirstVisiblePosition();
            int lastVisiblePosition = this.j.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.j.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    ImageView imageView = (ImageView) childAt.findViewById(R.id.select_icon);
                    int al = TiebaApplication.g().al();
                    if (z) {
                        if (al == 1) {
                            imageView.setBackgroundResource(R.drawable.btn_choose_photo_s_1);
                        } else {
                            imageView.setBackgroundResource(R.drawable.btn_choose_photo_s);
                        }
                    } else if (al == 1) {
                        imageView.setBackgroundResource(R.drawable.btn_choose_photo_n_1);
                    } else {
                        imageView.setBackgroundResource(R.drawable.btn_choose_photo_n);
                    }
                }
            }
        }
    }

    public void a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.k != null) {
            a(this.k.a(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tieba.album.t
    public void a(boolean z) {
        this.r = z;
        this.o = false;
        e();
    }

    private void e() {
        if (!isHidden()) {
            if (this.r) {
                this.j.setVisibility(8);
                this.l.setVisibility(0);
                return;
            }
            this.j.setVisibility(0);
            this.l.setVisibility(8);
            d();
        }
    }
}
