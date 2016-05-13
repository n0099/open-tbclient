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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.view.u;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class i extends PagerAdapter {
    private ArrayList<String> ajM;
    private Map<String, ImageUrlData> ajN;
    private a.d ajQ;
    private List<a> ajW;
    private u.b ajZ;
    private boolean akb;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener ajO = null;
    private a.e ajP = null;
    private int ajR = 0;
    private boolean ajS = false;
    private String ajT = null;
    private int ajU = 0;
    private int ajV = 0;
    private boolean ajX = false;
    private boolean ajY = false;
    private int aka = -1;

    /* loaded from: classes.dex */
    public interface a {
        View f(ViewGroup viewGroup, int i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public i(Context context, ArrayList<String> arrayList, a.d dVar) {
        this.mContext = null;
        this.ajM = null;
        this.ajQ = null;
        this.ajW = null;
        this.mContext = context;
        this.ajM = arrayList;
        this.ajQ = dVar;
        this.ajW = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.ajM = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.ajN = map;
    }

    public void setNextTitle(String str) {
        this.ajT = str;
    }

    public void setHasNext(boolean z) {
        this.ajS = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.ajW.add(aVar);
    }

    public boolean getHasNext() {
        return this.ajS;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.ajM != null) {
            i = this.ajM.size();
            if (this.ajS) {
                i++;
            }
        }
        return i + this.ajU + this.ajV;
    }

    public void setTempSize(int i) {
        this.ajU = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.ajV = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ajO = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.ajR = i;
    }

    public void a(a.e eVar) {
        this.ajP = eVar;
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
        if (this.ajW.size() != 0) {
            for (a aVar : this.ajW) {
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

    private u d(ViewGroup viewGroup, int i) {
        u uVar = new u(this.mContext);
        uVar.setOriImgSelectedCallback(this.ajZ);
        String str = null;
        if (i < this.ajM.size()) {
            str = this.ajM.get(i);
        }
        uVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        uVar.setImageOnClickListener(this.mOnClickListener);
        uVar.setImageOnLongClickListener(this.ajO);
        uVar.setIsCdn(this.ajX);
        uVar.setOnSizeChangedListener(this.ajP);
        ((ViewPager) viewGroup).addView(uVar, 0);
        uVar.setAssistUrl(eI(str));
        uVar.o(str, this.ajY);
        uVar.setGifMaxUseableMem(this.ajR);
        uVar.setTag(String.valueOf(i));
        uVar.setGifSetListener(this.ajQ);
        uVar.setHeadImage(this.akb);
        return uVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.ajS && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(t.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(t.g.image)).setImageDrawable(at.getDrawable(t.f.big_image_next_default));
            ((TextView) inflate.findViewById(t.g.thread_name)).setText(this.ajT);
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
            if (this.aka == i) {
                z = false;
            } else {
                this.aka = i;
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
            if (imageView != currentView || i == this.ajM.size() - 1) {
                if (currentView != null) {
                    currentView.FY();
                }
                ((u) obj).zO();
                ((u) obj).e(this.ajY, z);
                hVar.setCurrentView(imageView);
                if (((u) obj).getImageType() == 1) {
                    this.ajQ.a(imageView);
                }
            }
        }
    }

    private ImageUrlData eI(String str) {
        if (TextUtils.isEmpty(str) || this.ajN == null) {
            return null;
        }
        return this.ajN.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.ajY = z;
    }

    public void setIsCdn(boolean z) {
        this.ajX = z;
    }

    public void setHeadImage(boolean z) {
        this.akb = z;
    }

    public void setOriImgSelectedCallback(u.b bVar) {
        this.ajZ = bVar;
    }
}
