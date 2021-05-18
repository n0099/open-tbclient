package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class ImagePagerAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f12734a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, ImageUrlData> f12735b;

    /* renamed from: h  reason: collision with root package name */
    public DragImageView.i f12741h;

    /* renamed from: i  reason: collision with root package name */
    public b f12742i;
    public UrlDragImageView.p j;
    public DragImageView.h k;
    public boolean u;
    public boolean v;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f12736c = null;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f12737d = null;

    /* renamed from: e  reason: collision with root package name */
    public View.OnLongClickListener f12738e = null;

    /* renamed from: f  reason: collision with root package name */
    public View.OnTouchListener f12739f = null;

    /* renamed from: g  reason: collision with root package name */
    public DragImageView.k f12740g = null;
    public int m = 0;
    public boolean n = false;
    public String o = null;
    public int p = 0;
    public int q = 0;
    public boolean r = false;
    public boolean s = false;
    public int t = -1;
    public List<a> l = new ArrayList();

    /* loaded from: classes3.dex */
    public interface a {
        View a(ViewGroup viewGroup, int i2);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i2, Object obj);
    }

    public ImagePagerAdapter(Context context, DragImageView.i iVar) {
        this.f12734a = context;
        this.f12741h = iVar;
    }

    public void b(a aVar) {
        this.l.add(aVar);
    }

    public final ImageUrlData c(String str) {
        Map<String, ImageUrlData> map;
        if (TextUtils.isEmpty(str) || (map = this.f12735b) == null) {
            return null;
        }
        return map.get(str);
    }

    public final ImageUrlData d(String str) {
        Map<String, ImageUrlData> map;
        if (!TextUtils.isEmpty(str) && (map = this.f12735b) != null) {
            for (ImageUrlData imageUrlData : map.values()) {
                String str2 = imageUrlData.imageUrl;
                if (str2 != null && str2.equals(str)) {
                    return imageUrlData;
                }
            }
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        viewGroup.removeView((View) obj);
        if (obj instanceof UrlDragImageView) {
            ((UrlDragImageView) obj).X();
        }
    }

    public boolean e() {
        return this.n;
    }

    public final UrlDragImageView f(ViewGroup viewGroup, int i2) {
        String str = i2 < this.f12736c.size() ? this.f12736c.get(i2) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.f12734a);
        urlDragImageView.setOriImgSelectedCallback(this.j);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.f12737d);
        urlDragImageView.setImageOnLongClickListener(this.f12738e);
        urlDragImageView.setOuterOnTouchListener(this.f12739f);
        urlDragImageView.setIsCanDrag(this.u);
        urlDragImageView.setIsCdn(this.r);
        urlDragImageView.setOnSizeChangedListener(this.f12740g);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(c(str));
        urlDragImageView.setUrl(str, this.s);
        urlDragImageView.setGifMaxUseableMem(this.m);
        urlDragImageView.setTag(String.valueOf(i2));
        urlDragImageView.setGifSetListener(this.f12741h);
        urlDragImageView.setHeadImage(this.v);
        urlDragImageView.setDragToExitListener(this.k);
        return urlDragImageView;
    }

    public final View g(ViewGroup viewGroup, int i2) {
        if (this.n && i2 == getCount() - 1 && i2 != 0) {
            View inflate = LayoutInflater.from(this.f12734a).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(SkinManager.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.o);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.f12737d);
            return inflate;
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        int i2;
        ArrayList<String> arrayList = this.f12736c;
        if (arrayList != null) {
            i2 = arrayList.size();
            if (this.n) {
                i2++;
            }
        } else {
            i2 = 0;
        }
        return i2 + this.p + this.q;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        UrlDragImageView urlDragImageView;
        ImageUrlData imageUrlData;
        if ((obj instanceof UrlDragImageView) && (imageUrlData = (urlDragImageView = (UrlDragImageView) obj).getmAssistUrlData()) != null && !StringUtils.isNull(imageUrlData.imageUrl)) {
            urlDragImageView.setAssistUrl(d(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    public void h(int i2) {
        this.q = i2;
        notifyDataSetChanged();
    }

    public void i(boolean z) {
        this.s = z;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        List<a> list;
        View f2 = f(viewGroup, i2);
        if (f2 == null && (list = this.l) != null && list.size() != 0) {
            Iterator<a> it = this.l.iterator();
            while (it.hasNext() && (f2 = it.next().a(viewGroup, i2)) == null) {
            }
        }
        return f2 == null ? g(viewGroup, i2) : f2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    public void j(Map<String, ImageUrlData> map) {
        this.f12735b = map;
        notifyDataSetChanged();
    }

    public void k(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.f12736c = new ArrayList<>();
        } else {
            this.f12736c = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void l(DragImageView.h hVar) {
        this.k = hVar;
    }

    public void m(int i2) {
        this.m = i2;
    }

    public void n(boolean z) {
        this.n = z;
        notifyDataSetChanged();
    }

    public void o(boolean z) {
        this.v = z;
    }

    public void p(boolean z) {
        this.u = z;
    }

    public void q(boolean z) {
        this.r = z;
    }

    public void r(String str) {
        this.o = str;
    }

    public void s(View.OnClickListener onClickListener) {
        this.f12737d = onClickListener;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        super.setPrimaryItem(viewGroup, i2, obj);
        if (this.t == i2 || obj == null) {
            return;
        }
        b bVar = this.f12742i;
        if (bVar != null) {
            bVar.a(i2, obj);
        }
        this.t = i2;
    }

    public void t(View.OnLongClickListener onLongClickListener) {
        this.f12738e = onLongClickListener;
    }

    public void u(b bVar) {
        this.f12742i = bVar;
    }

    public void v(DragImageView.k kVar) {
        this.f12740g = kVar;
    }

    public void w(UrlDragImageView.p pVar) {
        this.j = pVar;
    }

    public void x(View.OnTouchListener onTouchListener) {
        this.f12739f = onTouchListener;
    }

    public void y(int i2) {
        this.p = i2;
        notifyDataSetChanged();
    }
}
