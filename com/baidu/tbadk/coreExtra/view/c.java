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
    private boolean awA;
    private ArrayList<String> awl;
    private Map<String, ImageUrlData> awm;
    private a.d awp;
    private List<a> awv;
    private f.b awy;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener awn = null;
    private a.e awo = null;
    private int awq = 0;
    private boolean awr = false;
    private String aws = null;
    private int awt = 0;
    private int awu = 0;
    private boolean aww = false;
    private boolean awx = false;
    private int awz = -1;

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
        this.awl = null;
        this.awp = null;
        this.awv = null;
        this.mContext = context;
        this.awl = arrayList;
        this.awp = dVar;
        this.awv = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.awl = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.awm = map;
    }

    public void setNextTitle(String str) {
        this.aws = str;
    }

    public void setHasNext(boolean z) {
        this.awr = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.awv.add(aVar);
    }

    public boolean getHasNext() {
        return this.awr;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.awl != null) {
            i = this.awl.size();
            if (this.awr) {
                i++;
            }
        }
        return i + this.awt + this.awu;
    }

    public void setTempSize(int i) {
        this.awt = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.awu = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.awn = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.awq = i;
    }

    public void a(a.e eVar) {
        this.awo = eVar;
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
        if (this.awv.size() != 0) {
            for (a aVar : this.awv) {
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
        fVar.setOriImgSelectedCallback(this.awy);
        String str = null;
        if (i < this.awl.size()) {
            str = this.awl.get(i);
        }
        fVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        fVar.setImageOnClickListener(this.mOnClickListener);
        fVar.setImageOnLongClickListener(this.awn);
        fVar.setIsCdn(this.aww);
        fVar.setOnSizeChangedListener(this.awo);
        ((ViewPager) viewGroup).addView(fVar, 0);
        fVar.setAssistUrl(fh(str));
        fVar.o(str, this.awx);
        fVar.setGifMaxUseableMem(this.awq);
        fVar.setTag(String.valueOf(i));
        fVar.setGifSetListener(this.awp);
        fVar.setHeadImage(this.awA);
        return fVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.awr && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.j.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(d.h.image)).setImageDrawable(ai.getDrawable(d.g.big_image_next_default));
            ((TextView) inflate.findViewById(d.h.thread_name)).setText(this.aws);
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
            if (this.awz == i) {
                z = false;
            } else {
                this.awz = i;
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
            if (imageView != currentView || i == this.awl.size() - 1) {
                if (currentView != null) {
                    currentView.HJ();
                }
                ((f) obj).BK();
                ((f) obj).h(this.awx, z);
                bVar.setCurrentView(imageView);
                if (((f) obj).getImageType() == 1) {
                    this.awp.a(imageView);
                }
            }
        }
    }

    private ImageUrlData fh(String str) {
        if (TextUtils.isEmpty(str) || this.awm == null) {
            return null;
        }
        return this.awm.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.awx = z;
    }

    public void setIsCdn(boolean z) {
        this.aww = z;
    }

    public void setHeadImage(boolean z) {
        this.awA = z;
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        this.awy = bVar;
    }
}
