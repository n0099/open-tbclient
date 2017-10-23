package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.coreExtra.view.f;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c extends PagerAdapter {
    private List<a> auD;
    private a.d auE;
    private f.b auH;
    private boolean auJ;
    private ArrayList<String> aus;
    private Map<String, ImageUrlData> aut;
    private a.e aux;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener auu = null;
    private View.OnTouchListener auv = null;
    private a.f auw = null;
    private int auy = 0;
    private boolean auz = false;
    private String auA = null;
    private int auB = 0;
    private int auC = 0;
    private boolean auF = false;
    private boolean auG = false;
    private int auI = -1;

    /* loaded from: classes.dex */
    public interface a {
        View e(ViewGroup viewGroup, int i);
    }

    public c(Context context, ArrayList<String> arrayList, a.e eVar) {
        this.mContext = null;
        this.aus = null;
        this.aux = null;
        this.auD = null;
        this.mContext = context;
        this.aus = arrayList;
        this.aux = eVar;
        this.auD = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.aus = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.aut = map;
    }

    public void setNextTitle(String str) {
        this.auA = str;
    }

    public void setHasNext(boolean z) {
        this.auz = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.auD.add(aVar);
    }

    public boolean getHasNext() {
        return this.auz;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.aus != null) {
            i = this.aus.size();
            if (this.auz) {
                i++;
            }
        }
        return i + this.auB + this.auC;
    }

    public void setTempSize(int i) {
        this.auB = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.auC = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.auv = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auu = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.auy = i;
    }

    public void a(a.f fVar) {
        this.auw = fVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
        if (obj instanceof f) {
            ((f) obj).onDestroy();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View c = c(viewGroup, i);
        if (c == null && this.auD.size() != 0) {
            Iterator<a> it = this.auD.iterator();
            while (it.hasNext() && (c = it.next().e(viewGroup, i)) == null) {
            }
        }
        if (c == null) {
            return d(viewGroup, i);
        }
        return c;
    }

    private f c(ViewGroup viewGroup, int i) {
        String str = i < this.aus.size() ? this.aus.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        f fVar = new f(this.mContext);
        fVar.setOriImgSelectedCallback(this.auH);
        fVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        fVar.setImageOnClickListener(this.mOnClickListener);
        fVar.setImageOnLongClickListener(this.auu);
        fVar.setOuterOnTouchListener(this.auv);
        fVar.setIsCdn(this.auF);
        fVar.setOnSizeChangedListener(this.auw);
        viewGroup.addView(fVar, 0);
        fVar.setAssistUrl(eY(str));
        fVar.n(str, this.auG);
        fVar.setGifMaxUseableMem(this.auy);
        fVar.setTag(String.valueOf(i));
        fVar.setGifSetListener(this.aux);
        fVar.setHeadImage(this.auJ);
        fVar.setDragToExitListener(this.auE);
        return fVar;
    }

    public void setDrageToExitListener(a.d dVar) {
        this.auE = dVar;
    }

    private View d(ViewGroup viewGroup, int i) {
        if (this.auz && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.j.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(d.h.image)).setImageDrawable(aj.getDrawable(d.g.big_image_next_default));
            ((TextView) inflate.findViewById(d.h.thread_name)).setText(this.auA);
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
            if (this.auI == i) {
                z = false;
            } else {
                this.auI = i;
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
            if (imageView != currentView || i == this.aus.size() - 1) {
                if (currentView != null) {
                    currentView.Hj();
                }
                ((f) obj).AX();
                ((f) obj).j(this.auG, z);
                bVar.setCurrentView(imageView);
                if (((f) obj).getImageType() == 1) {
                    this.aux.a(imageView);
                }
            }
        }
    }

    private ImageUrlData eY(String str) {
        if (TextUtils.isEmpty(str) || this.aut == null) {
            return null;
        }
        return this.aut.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.auG = z;
    }

    public void setIsCdn(boolean z) {
        this.auF = z;
    }

    public void setHeadImage(boolean z) {
        this.auJ = z;
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        this.auH = bVar;
    }
}
