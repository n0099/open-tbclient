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
    ViewGroup.LayoutParams hfD;
    RelativeLayout hfE;
    ArrayList<HeadImageView> hfC = new ArrayList<>();
    boolean loop = false;
    Handler handler = new Handler(Looper.getMainLooper());
    int position = 0;

    public i(ArrayList<String> arrayList, HeadImageView headImageView, RelativeLayout relativeLayout) {
        this.hfD = headImageView.getLayoutParams();
        this.context = headImageView.getContext();
        this.hfE = relativeLayout;
        headImageView.setVisibility(8);
        if (arrayList == null) {
            this.hfC.add(vy(0));
            this.hfC.add(vy(1));
            this.hfC.add(vy(0));
            this.hfC.add(vy(1));
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            this.hfC.add(Hl(it.next()));
        }
    }

    public void tk() {
        if (!this.hfC.isEmpty()) {
            if (this.hfC.size() == 1) {
                this.hfC.get(this.position).setVisibility(0);
                return;
            }
            this.loop = true;
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.i.1
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.position == 0) {
                        i.this.hfC.get(i.this.position).setVisibility(0);
                        i.this.hfC.get(i.this.hfC.size() - 1).setVisibility(8);
                    } else if (i.this.position == i.this.hfC.size() - 1) {
                        i.this.hfC.get(i.this.position - 1).setVisibility(8);
                        i.this.hfC.get(i.this.position).setVisibility(0);
                        i.this.position = -1;
                    } else {
                        i.this.hfC.get(i.this.position - 1).setVisibility(8);
                        i.this.hfC.get(i.this.position).setVisibility(0);
                    }
                    i.this.position++;
                    if (i.this.loop) {
                        i.this.handler.postDelayed(this, 500L);
                        return;
                    }
                    i.this.handler.removeCallbacksAndMessages(null);
                    Iterator<HeadImageView> it = i.this.hfC.iterator();
                    while (it.hasNext()) {
                        HeadImageView next = it.next();
                        next.setVisibility(8);
                        i.this.hfE.removeView(next);
                    }
                    i.this.hfC.clear();
                }
            }, 500L);
        }
    }

    public void bZU() {
        this.handler.removeCallbacksAndMessages(null);
        this.loop = false;
        Iterator<HeadImageView> it = this.hfC.iterator();
        while (it.hasNext()) {
            HeadImageView next = it.next();
            next.setVisibility(8);
            this.hfE.removeView(next);
        }
        this.hfC.clear();
    }

    public boolean ccN() {
        return this.hfC.size() != 0;
    }

    private HeadImageView Hl(String str) {
        HeadImageView headImageView = new HeadImageView(this.context);
        headImageView.startLoad(str, 25, false, false);
        headImageView.setIsRound(true);
        headImageView.setAutoChangeStyle(false);
        headImageView.setVisibility(8);
        this.hfE.addView(headImageView, this.hfD);
        return headImageView;
    }

    private HeadImageView vy(int i) {
        HeadImageView headImageView = new HeadImageView(this.context);
        if (i == 0) {
            headImageView.setImageResource(a.f.ala_icon_five_pointed_star);
        } else {
            headImageView.setImageResource(a.f.ala_icon_blank_five_pointed_star);
        }
        headImageView.setIsRound(true);
        headImageView.setAutoChangeStyle(false);
        headImageView.setVisibility(8);
        this.hfE.addView(headImageView, this.hfD);
        return headImageView;
    }
}
