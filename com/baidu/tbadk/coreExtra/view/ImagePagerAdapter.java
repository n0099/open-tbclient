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
    public Context f13753a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, ImageUrlData> f13754b;

    /* renamed from: h  reason: collision with root package name */
    public DragImageView.i f13760h;
    public b i;
    public UrlDragImageView.p j;
    public DragImageView.h k;
    public boolean u;
    public boolean v;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f13755c = null;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f13756d = null;

    /* renamed from: e  reason: collision with root package name */
    public View.OnLongClickListener f13757e = null;

    /* renamed from: f  reason: collision with root package name */
    public View.OnTouchListener f13758f = null;

    /* renamed from: g  reason: collision with root package name */
    public DragImageView.k f13759g = null;
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
        View a(ViewGroup viewGroup, int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, Object obj);
    }

    public ImagePagerAdapter(Context context, DragImageView.i iVar) {
        this.f13753a = context;
        this.f13760h = iVar;
    }

    public void A(int i) {
        this.p = i;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.l.add(aVar);
    }

    public final ImageUrlData b(String str) {
        Map<String, ImageUrlData> map;
        if (TextUtils.isEmpty(str) || (map = this.f13754b) == null) {
            return null;
        }
        return map.get(str);
    }

    public final ImageUrlData c(String str) {
        Map<String, ImageUrlData> map;
        if (!TextUtils.isEmpty(str) && (map = this.f13754b) != null) {
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
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
        if (obj instanceof UrlDragImageView) {
            ((UrlDragImageView) obj).X();
        }
    }

    public boolean e() {
        return this.n;
    }

    public final UrlDragImageView f(ViewGroup viewGroup, int i) {
        String str = i < this.f13755c.size() ? this.f13755c.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        UrlDragImageView urlDragImageView = new UrlDragImageView(this.f13753a);
        urlDragImageView.setOriImgSelectedCallback(this.j);
        urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        urlDragImageView.setImageOnClickListener(this.f13756d);
        urlDragImageView.setImageOnLongClickListener(this.f13757e);
        urlDragImageView.setOuterOnTouchListener(this.f13758f);
        urlDragImageView.setIsCanDrag(this.u);
        urlDragImageView.setIsCdn(this.r);
        urlDragImageView.setOnSizeChangedListener(this.f13759g);
        viewGroup.addView(urlDragImageView, 0);
        urlDragImageView.setAssistUrl(b(str));
        urlDragImageView.setUrl(str, this.s);
        urlDragImageView.setGifMaxUseableMem(this.m);
        urlDragImageView.setTag(String.valueOf(i));
        urlDragImageView.setGifSetListener(this.f13760h);
        urlDragImageView.setHeadImage(this.v);
        urlDragImageView.setDragToExitListener(this.k);
        return urlDragImageView;
    }

    public final View g(ViewGroup viewGroup, int i) {
        if (this.n && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.f13753a).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(SkinManager.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.o);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.f13756d);
            return inflate;
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        int i;
        ArrayList<String> arrayList = this.f13755c;
        if (arrayList != null) {
            i = arrayList.size();
            if (this.n) {
                i++;
            }
        } else {
            i = 0;
        }
        return i + this.p + this.q;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        UrlDragImageView urlDragImageView;
        ImageUrlData imageUrlData;
        if ((obj instanceof UrlDragImageView) && (imageUrlData = (urlDragImageView = (UrlDragImageView) obj).getmAssistUrlData()) != null && !StringUtils.isNull(imageUrlData.imageUrl)) {
            urlDragImageView.setAssistUrl(c(imageUrlData.imageUrl));
        }
        return super.getItemPosition(obj);
    }

    public void i(int i) {
        this.q = i;
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        List<a> list;
        View f2 = f(viewGroup, i);
        if (f2 == null && (list = this.l) != null && list.size() != 0) {
            Iterator<a> it = this.l.iterator();
            while (it.hasNext() && (f2 = it.next().a(viewGroup, i)) == null) {
            }
        }
        return f2 == null ? g(viewGroup, i) : f2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    public void j(boolean z) {
        this.s = z;
    }

    public void k(Map<String, ImageUrlData> map) {
        this.f13754b = map;
        notifyDataSetChanged();
    }

    public void l(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.f13755c = new ArrayList<>();
        } else {
            this.f13755c = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public void m(DragImageView.h hVar) {
        this.k = hVar;
    }

    public void n(int i) {
        this.m = i;
    }

    public void o(boolean z) {
        this.n = z;
        notifyDataSetChanged();
    }

    public void p(boolean z) {
        this.v = z;
    }

    public void q(boolean z) {
        this.u = z;
    }

    public void r(boolean z) {
        this.r = z;
    }

    public void s(String str) {
        this.o = str;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.t == i || obj == null) {
            return;
        }
        b bVar = this.i;
        if (bVar != null) {
            bVar.a(i, obj);
        }
        this.t = i;
    }

    public void u(View.OnClickListener onClickListener) {
        this.f13756d = onClickListener;
    }

    public void v(View.OnLongClickListener onLongClickListener) {
        this.f13757e = onLongClickListener;
    }

    public void w(b bVar) {
        this.i = bVar;
    }

    public void x(DragImageView.k kVar) {
        this.f13759g = kVar;
    }

    public void y(UrlDragImageView.p pVar) {
        this.j = pVar;
    }

    public void z(View.OnTouchListener onTouchListener) {
        this.f13758f = onTouchListener;
    }
}
