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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.coreExtra.view.f;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c extends PagerAdapter {
    private ArrayList<String> auU;
    private Map<String, ImageUrlData> auV;
    private a.d auY;
    private List<a> ave;
    private f.b avh;
    private boolean avj;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener auW = null;
    private a.e auX = null;
    private int auZ = 0;
    private boolean ava = false;
    private String avb = null;
    private int avc = 0;
    private int avd = 0;
    private boolean avf = false;
    private boolean avg = false;
    private int avi = -1;

    /* loaded from: classes.dex */
    public interface a {
        View f(ViewGroup viewGroup, int i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public c(Context context, ArrayList<String> arrayList, a.d dVar) {
        this.mContext = null;
        this.auU = null;
        this.auY = null;
        this.ave = null;
        this.mContext = context;
        this.auU = arrayList;
        this.auY = dVar;
        this.ave = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.auU = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.auV = map;
    }

    public void setNextTitle(String str) {
        this.avb = str;
    }

    public void setHasNext(boolean z) {
        this.ava = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.ave.add(aVar);
    }

    public boolean getHasNext() {
        return this.ava;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.auU != null) {
            i = this.auU.size();
            if (this.ava) {
                i++;
            }
        }
        return i + this.avc + this.avd;
    }

    public void setTempSize(int i) {
        this.avc = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.avd = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auW = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.auZ = i;
    }

    public void a(a.e eVar) {
        this.auX = eVar;
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
        if (this.ave.size() != 0) {
            for (a aVar : this.ave) {
                View f = aVar.f(viewGroup, i);
                if (f != null) {
                    return f;
                }
            }
        }
        View e = e(viewGroup, i);
        if (e == null) {
            return d(viewGroup, i);
        }
        return e;
    }

    private f d(ViewGroup viewGroup, int i) {
        f fVar = new f(this.mContext);
        fVar.setOriImgSelectedCallback(this.avh);
        String str = null;
        if (i < this.auU.size()) {
            str = this.auU.get(i);
        }
        fVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        fVar.setImageOnClickListener(this.mOnClickListener);
        fVar.setImageOnLongClickListener(this.auW);
        fVar.setIsCdn(this.avf);
        fVar.setOnSizeChangedListener(this.auX);
        ((ViewPager) viewGroup).addView(fVar, 0);
        fVar.setAssistUrl(fb(str));
        fVar.o(str, this.avg);
        fVar.setGifMaxUseableMem(this.auZ);
        fVar.setTag(String.valueOf(i));
        fVar.setGifSetListener(this.auY);
        fVar.setHeadImage(this.avj);
        return fVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.ava && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.j.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(d.h.image)).setImageDrawable(ai.getDrawable(d.g.big_image_next_default));
            ((TextView) inflate.findViewById(d.h.thread_name)).setText(this.avb);
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
            if (this.avi == i) {
                z = false;
            } else {
                this.avi = i;
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
            if (imageView != currentView || i == this.auU.size() - 1) {
                if (currentView != null) {
                    currentView.HB();
                }
                ((f) obj).BC();
                ((f) obj).h(this.avg, z);
                bVar.setCurrentView(imageView);
                if (((f) obj).getImageType() == 1) {
                    this.auY.a(imageView);
                }
            }
        }
    }

    private ImageUrlData fb(String str) {
        if (TextUtils.isEmpty(str) || this.auV == null) {
            return null;
        }
        return this.auV.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.avg = z;
    }

    public void setIsCdn(boolean z) {
        this.avf = z;
    }

    public void setHeadImage(boolean z) {
        this.avj = z;
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        this.avh = bVar;
    }
}
