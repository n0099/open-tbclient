package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.coreExtra.view.f;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c extends PagerAdapter {
    private a.d avA;
    private List<a> avG;
    private f.b avJ;
    private boolean avL;
    private ArrayList<String> avw;
    private Map<String, ImageUrlData> avx;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener avy = null;
    private a.e avz = null;
    private int avB = 0;
    private boolean avC = false;
    private String avD = null;
    private int avE = 0;
    private int avF = 0;
    private boolean avH = false;
    private boolean avI = false;
    private int avK = -1;

    /* loaded from: classes.dex */
    public interface a {
        View e(ViewGroup viewGroup, int i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public c(Context context, ArrayList<String> arrayList, a.d dVar) {
        this.mContext = null;
        this.avw = null;
        this.avA = null;
        this.avG = null;
        this.mContext = context;
        this.avw = arrayList;
        this.avA = dVar;
        this.avG = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.avw = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.avx = map;
    }

    public void setNextTitle(String str) {
        this.avD = str;
    }

    public void setHasNext(boolean z) {
        this.avC = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.avG.add(aVar);
    }

    public boolean getHasNext() {
        return this.avC;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.avw != null) {
            i = this.avw.size();
            if (this.avC) {
                i++;
            }
        }
        return i + this.avE + this.avF;
    }

    public void setTempSize(int i) {
        this.avE = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.avF = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avy = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.avB = i;
    }

    public void a(a.e eVar) {
        this.avz = eVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
        if (obj instanceof f) {
            ((f) obj).onDestroy();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.avG.size() != 0) {
            for (a aVar : this.avG) {
                View e = aVar.e(viewGroup, i);
                if (e != null) {
                    return e;
                }
            }
        }
        View d = d(viewGroup, i);
        if (d == null) {
            return c(viewGroup, i);
        }
        return d;
    }

    private f c(ViewGroup viewGroup, int i) {
        f fVar = new f(this.mContext);
        fVar.setOriImgSelectedCallback(this.avJ);
        String str = null;
        if (i < this.avw.size()) {
            str = this.avw.get(i);
        }
        fVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        fVar.setImageOnClickListener(this.mOnClickListener);
        fVar.setImageOnLongClickListener(this.avy);
        fVar.setIsCdn(this.avH);
        fVar.setOnSizeChangedListener(this.avz);
        ((ViewPager) viewGroup).addView(fVar, 0);
        fVar.setAssistUrl(fg(str));
        fVar.o(str, this.avI);
        fVar.setGifMaxUseableMem(this.avB);
        fVar.setTag(String.valueOf(i));
        fVar.setGifSetListener(this.avA);
        fVar.setHeadImage(this.avL);
        return fVar;
    }

    private View d(ViewGroup viewGroup, int i) {
        if (this.avC && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.j.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(d.h.image)).setImageDrawable(aj.getDrawable(d.g.big_image_next_default));
            ((TextView) inflate.findViewById(d.h.thread_name)).setText(this.avD);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.mOnClickListener);
            return inflate;
        }
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        boolean z;
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof f) {
            if (this.avK == i) {
                z = false;
            } else {
                this.avK = i;
                z = true;
            }
            b bVar = (b) viewGroup;
            com.baidu.tbadk.widget.a imageView = ((f) obj).getImageView();
            if (bVar.getSelectedView() == null) {
                bVar.setSelectedView(imageView);
                ViewParent parent = bVar.getParent();
                if (parent != null && (parent instanceof MultiImageView)) {
                    ((MultiImageView) parent).setZoomButton(imageView);
                }
            }
            com.baidu.tbadk.widget.a currentView = bVar.getCurrentView();
            if (imageView != currentView || i == this.avw.size() - 1) {
                if (currentView != null) {
                    currentView.HI();
                }
                ((f) obj).BF();
                ((f) obj).i(this.avI, z);
                bVar.setCurrentView(imageView);
                if (((f) obj).getImageType() == 1) {
                    this.avA.a(imageView);
                }
            }
        }
    }

    private ImageUrlData fg(String str) {
        if (TextUtils.isEmpty(str) || this.avx == null) {
            return null;
        }
        return this.avx.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.avI = z;
    }

    public void setIsCdn(boolean z) {
        this.avH = z;
    }

    public void setHeadImage(boolean z) {
        this.avL = z;
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        this.avJ = bVar;
    }
}
