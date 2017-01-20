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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.view.u;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class i extends PagerAdapter {
    private a.d anC;
    private List<a> anI;
    private u.b anL;
    private boolean anN;
    private ArrayList<String> any;
    private Map<String, ImageUrlData> anz;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener anA = null;
    private a.e anB = null;
    private int anD = 0;
    private boolean anE = false;
    private String anF = null;
    private int anG = 0;
    private int anH = 0;
    private boolean anJ = false;
    private boolean anK = false;
    private int anM = -1;

    /* loaded from: classes.dex */
    public interface a {
        View g(ViewGroup viewGroup, int i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public i(Context context, ArrayList<String> arrayList, a.d dVar) {
        this.mContext = null;
        this.any = null;
        this.anC = null;
        this.anI = null;
        this.mContext = context;
        this.any = arrayList;
        this.anC = dVar;
        this.anI = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.any = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.anz = map;
    }

    public void setNextTitle(String str) {
        this.anF = str;
    }

    public void setHasNext(boolean z) {
        this.anE = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.anI.add(aVar);
    }

    public boolean getHasNext() {
        return this.anE;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.any != null) {
            i = this.any.size();
            if (this.anE) {
                i++;
            }
        }
        return i + this.anG + this.anH;
    }

    public void setTempSize(int i) {
        this.anG = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.anH = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.anA = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.anD = i;
    }

    public void a(a.e eVar) {
        this.anB = eVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
        if (obj instanceof u) {
            ((u) obj).onDestroy();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.anI.size() != 0) {
            for (a aVar : this.anI) {
                View g = aVar.g(viewGroup, i);
                if (g != null) {
                    return g;
                }
            }
        }
        View f = f(viewGroup, i);
        if (f == null) {
            return e(viewGroup, i);
        }
        return f;
    }

    private u e(ViewGroup viewGroup, int i) {
        u uVar = new u(this.mContext);
        uVar.setOriImgSelectedCallback(this.anL);
        String str = null;
        if (i < this.any.size()) {
            str = this.any.get(i);
        }
        uVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        uVar.setImageOnClickListener(this.mOnClickListener);
        uVar.setImageOnLongClickListener(this.anA);
        uVar.setIsCdn(this.anJ);
        uVar.setOnSizeChangedListener(this.anB);
        ((ViewPager) viewGroup).addView(uVar, 0);
        uVar.setAssistUrl(eL(str));
        uVar.q(str, this.anK);
        uVar.setGifMaxUseableMem(this.anD);
        uVar.setTag(String.valueOf(i));
        uVar.setGifSetListener(this.anC);
        uVar.setHeadImage(this.anN);
        return uVar;
    }

    private View f(ViewGroup viewGroup, int i) {
        if (this.anE && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(r.j.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(r.h.image)).setImageDrawable(ap.getDrawable(r.g.big_image_next_default));
            ((TextView) inflate.findViewById(r.h.thread_name)).setText(this.anF);
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
        if (obj instanceof u) {
            if (this.anM == i) {
                z = false;
            } else {
                this.anM = i;
                z = true;
            }
            h hVar = (h) viewGroup;
            com.baidu.tbadk.widget.a imageView = ((u) obj).getImageView();
            if (hVar.getSelectedView() == null) {
                hVar.setSelectedView(imageView);
                ViewParent parent = hVar.getParent();
                if (parent != null && (parent instanceof MultiImageView)) {
                    ((MultiImageView) parent).setZoomButton(imageView);
                }
            }
            com.baidu.tbadk.widget.a currentView = hVar.getCurrentView();
            if (imageView != currentView || i == this.any.size() - 1) {
                if (currentView != null) {
                    currentView.GM();
                }
                ((u) obj).Bb();
                ((u) obj).g(this.anK, z);
                hVar.setCurrentView(imageView);
                if (((u) obj).getImageType() == 1) {
                    this.anC.a(imageView);
                }
            }
        }
    }

    private ImageUrlData eL(String str) {
        if (TextUtils.isEmpty(str) || this.anz == null) {
            return null;
        }
        return this.anz.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.anK = z;
    }

    public void setIsCdn(boolean z) {
        this.anJ = z;
    }

    public void setHeadImage(boolean z) {
        this.anN = z;
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        this.anL = bVar;
    }
}
