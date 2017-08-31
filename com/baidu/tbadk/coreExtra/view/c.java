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
    private Map<String, ImageUrlData> avA;
    private a.d avD;
    private List<a> avJ;
    private f.b avM;
    private boolean avO;
    private ArrayList<String> avz;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener avB = null;
    private a.e avC = null;
    private int avE = 0;
    private boolean avF = false;
    private String avG = null;
    private int avH = 0;
    private int avI = 0;
    private boolean avK = false;
    private boolean avL = false;
    private int avN = -1;

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
        this.avz = null;
        this.avD = null;
        this.avJ = null;
        this.mContext = context;
        this.avz = arrayList;
        this.avD = dVar;
        this.avJ = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.avz = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.avA = map;
    }

    public void setNextTitle(String str) {
        this.avG = str;
    }

    public void setHasNext(boolean z) {
        this.avF = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.avJ.add(aVar);
    }

    public boolean getHasNext() {
        return this.avF;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.avz != null) {
            i = this.avz.size();
            if (this.avF) {
                i++;
            }
        }
        return i + this.avH + this.avI;
    }

    public void setTempSize(int i) {
        this.avH = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.avI = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avB = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.avE = i;
    }

    public void a(a.e eVar) {
        this.avC = eVar;
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
        if (this.avJ.size() != 0) {
            for (a aVar : this.avJ) {
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
        fVar.setOriImgSelectedCallback(this.avM);
        String str = null;
        if (i < this.avz.size()) {
            str = this.avz.get(i);
        }
        fVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        fVar.setImageOnClickListener(this.mOnClickListener);
        fVar.setImageOnLongClickListener(this.avB);
        fVar.setIsCdn(this.avK);
        fVar.setOnSizeChangedListener(this.avC);
        ((ViewPager) viewGroup).addView(fVar, 0);
        fVar.setAssistUrl(fg(str));
        fVar.o(str, this.avL);
        fVar.setGifMaxUseableMem(this.avE);
        fVar.setTag(String.valueOf(i));
        fVar.setGifSetListener(this.avD);
        fVar.setHeadImage(this.avO);
        return fVar;
    }

    private View d(ViewGroup viewGroup, int i) {
        if (this.avF && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.j.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(d.h.image)).setImageDrawable(aj.getDrawable(d.g.big_image_next_default));
            ((TextView) inflate.findViewById(d.h.thread_name)).setText(this.avG);
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
            if (this.avN == i) {
                z = false;
            } else {
                this.avN = i;
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
            if (imageView != currentView || i == this.avz.size() - 1) {
                if (currentView != null) {
                    currentView.HI();
                }
                ((f) obj).BF();
                ((f) obj).i(this.avL, z);
                bVar.setCurrentView(imageView);
                if (((f) obj).getImageType() == 1) {
                    this.avD.a(imageView);
                }
            }
        }
    }

    private ImageUrlData fg(String str) {
        if (TextUtils.isEmpty(str) || this.avA == null) {
            return null;
        }
        return this.avA.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.avL = z;
    }

    public void setIsCdn(boolean z) {
        this.avK = z;
    }

    public void setHeadImage(boolean z) {
        this.avO = z;
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        this.avM = bVar;
    }
}
