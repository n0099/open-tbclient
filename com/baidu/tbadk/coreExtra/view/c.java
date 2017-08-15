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
    private boolean awB;
    private ArrayList<String> awm;
    private Map<String, ImageUrlData> awn;
    private a.d awq;
    private List<a> aww;
    private f.b awz;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener awo = null;
    private a.e awp = null;
    private int awr = 0;
    private boolean aws = false;
    private String awt = null;
    private int awu = 0;
    private int awv = 0;
    private boolean awx = false;
    private boolean awy = false;
    private int awA = -1;

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
        this.awm = null;
        this.awq = null;
        this.aww = null;
        this.mContext = context;
        this.awm = arrayList;
        this.awq = dVar;
        this.aww = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.awm = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.awn = map;
    }

    public void setNextTitle(String str) {
        this.awt = str;
    }

    public void setHasNext(boolean z) {
        this.aws = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.aww.add(aVar);
    }

    public boolean getHasNext() {
        return this.aws;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.awm != null) {
            i = this.awm.size();
            if (this.aws) {
                i++;
            }
        }
        return i + this.awu + this.awv;
    }

    public void setTempSize(int i) {
        this.awu = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.awv = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.awo = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.awr = i;
    }

    public void a(a.e eVar) {
        this.awp = eVar;
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
        if (this.aww.size() != 0) {
            for (a aVar : this.aww) {
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
        fVar.setOriImgSelectedCallback(this.awz);
        String str = null;
        if (i < this.awm.size()) {
            str = this.awm.get(i);
        }
        fVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        fVar.setImageOnClickListener(this.mOnClickListener);
        fVar.setImageOnLongClickListener(this.awo);
        fVar.setIsCdn(this.awx);
        fVar.setOnSizeChangedListener(this.awp);
        ((ViewPager) viewGroup).addView(fVar, 0);
        fVar.setAssistUrl(fh(str));
        fVar.o(str, this.awy);
        fVar.setGifMaxUseableMem(this.awr);
        fVar.setTag(String.valueOf(i));
        fVar.setGifSetListener(this.awq);
        fVar.setHeadImage(this.awB);
        return fVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.aws && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.j.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(d.h.image)).setImageDrawable(ai.getDrawable(d.g.big_image_next_default));
            ((TextView) inflate.findViewById(d.h.thread_name)).setText(this.awt);
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
            if (this.awA == i) {
                z = false;
            } else {
                this.awA = i;
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
            if (imageView != currentView || i == this.awm.size() - 1) {
                if (currentView != null) {
                    currentView.HJ();
                }
                ((f) obj).BK();
                ((f) obj).h(this.awy, z);
                bVar.setCurrentView(imageView);
                if (((f) obj).getImageType() == 1) {
                    this.awq.a(imageView);
                }
            }
        }
    }

    private ImageUrlData fh(String str) {
        if (TextUtils.isEmpty(str) || this.awn == null) {
            return null;
        }
        return this.awn.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.awy = z;
    }

    public void setIsCdn(boolean z) {
        this.awx = z;
    }

    public void setHeadImage(boolean z) {
        this.awB = z;
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        this.awz = bVar;
    }
}
