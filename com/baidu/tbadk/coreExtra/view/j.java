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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.view.z;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class j extends PagerAdapter {
    private ArrayList<String> ajS;
    private HashMap<String, ImageUrlData> ajT;
    private a.d ajW;
    private List<a> akc;
    private z.b akf;
    private boolean akg;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener ajU = null;
    private a.e ajV = null;
    private int ajX = 0;
    private boolean ajY = false;
    private String ajZ = null;
    private int aka = 0;
    private int akb = 0;
    private boolean akd = false;
    private boolean ake = false;

    /* loaded from: classes.dex */
    public interface a {
        View f(ViewGroup viewGroup, int i);
    }

    public j(Context context, ArrayList<String> arrayList, a.d dVar) {
        this.mContext = null;
        this.ajS = null;
        this.ajW = null;
        this.akc = null;
        this.mContext = context;
        this.ajS = arrayList;
        this.ajW = dVar;
        this.akc = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.ajS = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(HashMap<String, ImageUrlData> hashMap) {
        this.ajT = hashMap;
    }

    public void setNextTitle(String str) {
        this.ajZ = str;
    }

    public void setHasNext(boolean z) {
        this.ajY = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.akc.add(aVar);
    }

    public boolean getHasNext() {
        return this.ajY;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.ajS != null) {
            i = this.ajS.size();
            if (this.ajY) {
                i++;
            }
        }
        return i + this.aka + this.akb;
    }

    public void setTempSize(int i) {
        this.aka = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.akb = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ajU = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.ajX = i;
    }

    public void a(a.e eVar) {
        this.ajV = eVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
        if (obj instanceof z) {
            ((z) obj).onDestroy();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.akc.size() != 0) {
            for (a aVar : this.akc) {
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

    private z d(ViewGroup viewGroup, int i) {
        z zVar = new z(this.mContext);
        zVar.setOriImgSelectedCallback(this.akf);
        String str = null;
        if (i < this.ajS.size()) {
            str = this.ajS.get(i);
        }
        zVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        zVar.setImageOnClickListener(this.mOnClickListener);
        zVar.setImageOnLongClickListener(this.ajU);
        zVar.setIsCdn(this.akd);
        zVar.setOnSizeChangedListener(this.ajV);
        ((ViewPager) viewGroup).addView(zVar, 0);
        zVar.setAssistUrl(es(str));
        zVar.p(str, this.ake);
        zVar.setGifMaxUseableMem(this.ajX);
        zVar.setTag(String.valueOf(i));
        zVar.setGifSetListener(this.ajW);
        zVar.setHeadImage(this.akg);
        return zVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.ajY && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(i.g.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(i.f.image)).setImageDrawable(an.getDrawable(i.e.big_image_next_default));
            ((TextView) inflate.findViewById(i.f.thread_name)).setText(this.ajZ);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.mOnClickListener);
            return inflate;
        }
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof z) {
            i iVar = (i) viewGroup;
            com.baidu.tbadk.widget.a imageView = ((z) obj).getImageView();
            if (iVar.getSelectedView() == null) {
                iVar.setSelectedView(imageView);
                ViewParent parent = iVar.getParent();
                if (parent != null && (parent instanceof MultiImageView)) {
                    ((MultiImageView) parent).setZoomButton(imageView);
                }
            }
            com.baidu.tbadk.widget.a currentView = iVar.getCurrentView();
            if (imageView != currentView || i == this.ajS.size() - 1) {
                if (currentView != null) {
                    currentView.restoreSize();
                }
                ((z) obj).zm();
                ((z) obj).aT(this.ake);
                iVar.setCurrentView(imageView);
                if (((z) obj).getImageType() == 1) {
                    this.ajW.a(imageView);
                }
            }
        }
    }

    private ImageUrlData es(String str) {
        if (TextUtils.isEmpty(str) || this.ajT == null) {
            return null;
        }
        return this.ajT.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.ake = z;
    }

    public void setIsCdn(boolean z) {
        this.akd = z;
    }

    public void setHeadImage(boolean z) {
        this.akg = z;
    }

    public void setOriImgSelectedCallback(z.b bVar) {
        this.akf = bVar;
    }
}
