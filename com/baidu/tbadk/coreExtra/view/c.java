package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    private f auO;
    private Map<String, ImageUrlData> auQ;
    private a.e auU;
    private List<a> ava;
    private a.d avb;
    private f.b ave;
    private boolean avf;
    private b avg;
    private boolean avh;
    private Context mContext;
    private ArrayList<String> auP = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener auR = null;
    private View.OnTouchListener auS = null;
    private a.f auT = null;
    private int auV = 0;
    private boolean auW = false;
    private String auX = null;
    private int auY = 0;
    private int auZ = 0;
    private boolean avc = false;
    private boolean avd = false;
    private int mPosition = -1;

    /* loaded from: classes.dex */
    public interface a {
        View e(ViewGroup viewGroup, int i);
    }

    public c(Context context, b bVar, a.e eVar) {
        this.mContext = null;
        this.auU = null;
        this.ava = null;
        this.mContext = context;
        this.avg = bVar;
        this.auU = eVar;
        this.ava = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.auP = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.auQ = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.auX = str;
    }

    public void setHasNext(boolean z) {
        this.auW = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.ava.add(aVar);
    }

    public boolean getHasNext() {
        return this.auW;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.auP != null) {
            i = this.auP.size();
            if (this.auW) {
                i++;
            }
        }
        return i + this.auY + this.auZ;
    }

    public void setTempSize(int i) {
        this.auY = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.auZ = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.auS = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auR = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.auV = i;
    }

    public void a(a.f fVar) {
        this.auT = fVar;
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
        if (c == null && this.ava != null && this.ava.size() != 0) {
            Iterator<a> it = this.ava.iterator();
            while (it.hasNext() && (c = it.next().e(viewGroup, i)) == null) {
            }
        }
        if (c == null) {
            return d(viewGroup, i);
        }
        return c;
    }

    public void setIsCanDrag(boolean z) {
        this.avf = z;
    }

    private f c(ViewGroup viewGroup, int i) {
        String str = i < this.auP.size() ? this.auP.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        f fVar = new f(this.mContext);
        fVar.setOriImgSelectedCallback(this.ave);
        fVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        fVar.setImageOnClickListener(this.mOnClickListener);
        fVar.setImageOnLongClickListener(this.auR);
        fVar.setOuterOnTouchListener(this.auS);
        fVar.setIsCanDrag(this.avf);
        fVar.setIsCdn(this.avc);
        fVar.setOnSizeChangedListener(this.auT);
        viewGroup.addView(fVar, 0);
        fVar.setAssistUrl(ff(str));
        fVar.n(str, this.avd);
        fVar.setGifMaxUseableMem(this.auV);
        fVar.setTag(String.valueOf(i));
        fVar.setGifSetListener(this.auU);
        fVar.setHeadImage(this.avh);
        fVar.setDragToExitListener(this.avb);
        return fVar;
    }

    public void setDrageToExitListener(a.d dVar) {
        this.avb = dVar;
    }

    private View d(ViewGroup viewGroup, int i) {
        if (this.auW && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(d.g.image)).setImageDrawable(aj.getDrawable(d.f.big_image_next_default));
            ((TextView) inflate.findViewById(d.g.thread_name)).setText(this.auX);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.mOnClickListener);
            return inflate;
        }
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.mPosition != i) {
                com.baidu.tbadk.widget.a imageView = fVar.getImageView();
                if (imageView != null) {
                    imageView.Hv();
                    this.avg.setCurrentView(imageView);
                    if (imageView.getImageType() == 1) {
                        this.auU.a(imageView);
                    }
                }
                fVar.Bk();
                fVar.Bj();
                fVar.j(this.avd, true);
                this.mPosition = i;
                this.auO = fVar;
            }
        }
    }

    private ImageUrlData ff(String str) {
        if (TextUtils.isEmpty(str) || this.auQ == null) {
            return null;
        }
        return this.auQ.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.avd = z;
    }

    public void setIsCdn(boolean z) {
        this.avc = z;
    }

    public void setHeadImage(boolean z) {
        this.avh = z;
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        this.ave = bVar;
    }
}
