package com.baidu.tieba.ala.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class i {
    Context context;
    ViewGroup.LayoutParams hNa;
    RelativeLayout hNb;
    ArrayList<HeadImageView> hMZ = new ArrayList<>();
    boolean loop = false;
    Handler handler = new Handler(Looper.getMainLooper());
    int position = 0;

    public i(ArrayList<String> arrayList, HeadImageView headImageView, RelativeLayout relativeLayout) {
        this.hNa = headImageView.getLayoutParams();
        this.context = headImageView.getContext();
        this.hNb = relativeLayout;
        headImageView.setVisibility(8);
        if (arrayList == null) {
            this.hMZ.add(wK(0));
            this.hMZ.add(wK(1));
            this.hMZ.add(wK(0));
            this.hMZ.add(wK(1));
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            this.hMZ.add(IP(it.next()));
        }
    }

    public void tk() {
        if (!this.hMZ.isEmpty()) {
            if (this.hMZ.size() == 1) {
                this.hMZ.get(this.position).setVisibility(0);
                return;
            }
            this.loop = true;
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.i.1
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.position == 0) {
                        i.this.hMZ.get(i.this.position).setVisibility(0);
                        i.this.hMZ.get(i.this.hMZ.size() - 1).setVisibility(8);
                    } else if (i.this.position == i.this.hMZ.size() - 1) {
                        i.this.hMZ.get(i.this.position - 1).setVisibility(8);
                        i.this.hMZ.get(i.this.position).setVisibility(0);
                        i.this.position = -1;
                    } else {
                        i.this.hMZ.get(i.this.position - 1).setVisibility(8);
                        i.this.hMZ.get(i.this.position).setVisibility(0);
                    }
                    i.this.position++;
                    if (i.this.loop) {
                        i.this.handler.postDelayed(this, 500L);
                        return;
                    }
                    i.this.handler.removeCallbacksAndMessages(null);
                    Iterator<HeadImageView> it = i.this.hMZ.iterator();
                    while (it.hasNext()) {
                        HeadImageView next = it.next();
                        next.setVisibility(8);
                        i.this.hNb.removeView(next);
                    }
                    i.this.hMZ.clear();
                }
            }, 500L);
        }
    }

    public void ciW() {
        this.handler.removeCallbacksAndMessages(null);
        this.loop = false;
        Iterator<HeadImageView> it = this.hMZ.iterator();
        while (it.hasNext()) {
            HeadImageView next = it.next();
            next.setVisibility(8);
            this.hNb.removeView(next);
        }
        this.hMZ.clear();
    }

    public boolean clS() {
        return this.hMZ.size() != 0;
    }

    private HeadImageView IP(String str) {
        HeadImageView headImageView = new HeadImageView(this.context);
        headImageView.startLoad(str, 25, false, false);
        headImageView.setIsRound(true);
        headImageView.setAutoChangeStyle(false);
        headImageView.setVisibility(8);
        this.hNb.addView(headImageView, this.hNa);
        return headImageView;
    }

    private HeadImageView wK(int i) {
        HeadImageView headImageView = new HeadImageView(this.context);
        if (i == 0) {
            headImageView.setImageResource(a.e.ala_icon_five_pointed_star);
        } else {
            headImageView.setImageResource(a.e.ala_icon_blank_five_pointed_star);
        }
        headImageView.setIsRound(true);
        headImageView.setAutoChangeStyle(false);
        headImageView.setVisibility(8);
        this.hNb.addView(headImageView, this.hNa);
        return headImageView;
    }
}
