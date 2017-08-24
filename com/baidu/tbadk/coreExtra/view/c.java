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
    private f.b awA;
    private boolean awC;
    private ArrayList<String> awn;
    private Map<String, ImageUrlData> awo;
    private a.d awr;
    private List<a> awx;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener awp = null;
    private a.e awq = null;
    private int aws = 0;
    private boolean awt = false;
    private String awu = null;
    private int awv = 0;
    private int aww = 0;
    private boolean awy = false;
    private boolean awz = false;
    private int awB = -1;

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
        this.awn = null;
        this.awr = null;
        this.awx = null;
        this.mContext = context;
        this.awn = arrayList;
        this.awr = dVar;
        this.awx = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.awn = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.awo = map;
    }

    public void setNextTitle(String str) {
        this.awu = str;
    }

    public void setHasNext(boolean z) {
        this.awt = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.awx.add(aVar);
    }

    public boolean getHasNext() {
        return this.awt;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.awn != null) {
            i = this.awn.size();
            if (this.awt) {
                i++;
            }
        }
        return i + this.awv + this.aww;
    }

    public void setTempSize(int i) {
        this.awv = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.aww = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.awp = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.aws = i;
    }

    public void a(a.e eVar) {
        this.awq = eVar;
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
        if (this.awx.size() != 0) {
            for (a aVar : this.awx) {
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
        fVar.setOriImgSelectedCallback(this.awA);
        String str = null;
        if (i < this.awn.size()) {
            str = this.awn.get(i);
        }
        fVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        fVar.setImageOnClickListener(this.mOnClickListener);
        fVar.setImageOnLongClickListener(this.awp);
        fVar.setIsCdn(this.awy);
        fVar.setOnSizeChangedListener(this.awq);
        ((ViewPager) viewGroup).addView(fVar, 0);
        fVar.setAssistUrl(fl(str));
        fVar.o(str, this.awz);
        fVar.setGifMaxUseableMem(this.aws);
        fVar.setTag(String.valueOf(i));
        fVar.setGifSetListener(this.awr);
        fVar.setHeadImage(this.awC);
        return fVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.awt && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.j.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(d.h.image)).setImageDrawable(ai.getDrawable(d.g.big_image_next_default));
            ((TextView) inflate.findViewById(d.h.thread_name)).setText(this.awu);
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
            if (this.awB == i) {
                z = false;
            } else {
                this.awB = i;
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
            if (imageView != currentView || i == this.awn.size() - 1) {
                if (currentView != null) {
                    currentView.HJ();
                }
                ((f) obj).BK();
                ((f) obj).h(this.awz, z);
                bVar.setCurrentView(imageView);
                if (((f) obj).getImageType() == 1) {
                    this.awr.a(imageView);
                }
            }
        }
    }

    private ImageUrlData fl(String str) {
        if (TextUtils.isEmpty(str) || this.awo == null) {
            return null;
        }
        return this.awo.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.awz = z;
    }

    public void setIsCdn(boolean z) {
        this.awy = z;
    }

    public void setHeadImage(boolean z) {
        this.awC = z;
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        this.awA = bVar;
    }
}
