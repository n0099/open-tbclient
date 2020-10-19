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
    ViewGroup.LayoutParams huG;
    RelativeLayout huH;
    ArrayList<HeadImageView> huF = new ArrayList<>();
    boolean loop = false;
    Handler handler = new Handler(Looper.getMainLooper());
    int position = 0;

    public i(ArrayList<String> arrayList, HeadImageView headImageView, RelativeLayout relativeLayout) {
        this.huG = headImageView.getLayoutParams();
        this.context = headImageView.getContext();
        this.huH = relativeLayout;
        headImageView.setVisibility(8);
        if (arrayList == null) {
            this.huF.add(we(0));
            this.huF.add(we(1));
            this.huF.add(we(0));
            this.huF.add(we(1));
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            this.huF.add(HZ(it.next()));
        }
    }

    public void tk() {
        if (!this.huF.isEmpty()) {
            if (this.huF.size() == 1) {
                this.huF.get(this.position).setVisibility(0);
                return;
            }
            this.loop = true;
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.i.1
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.position == 0) {
                        i.this.huF.get(i.this.position).setVisibility(0);
                        i.this.huF.get(i.this.huF.size() - 1).setVisibility(8);
                    } else if (i.this.position == i.this.huF.size() - 1) {
                        i.this.huF.get(i.this.position - 1).setVisibility(8);
                        i.this.huF.get(i.this.position).setVisibility(0);
                        i.this.position = -1;
                    } else {
                        i.this.huF.get(i.this.position - 1).setVisibility(8);
                        i.this.huF.get(i.this.position).setVisibility(0);
                    }
                    i.this.position++;
                    if (i.this.loop) {
                        i.this.handler.postDelayed(this, 500L);
                        return;
                    }
                    i.this.handler.removeCallbacksAndMessages(null);
                    Iterator<HeadImageView> it = i.this.huF.iterator();
                    while (it.hasNext()) {
                        HeadImageView next = it.next();
                        next.setVisibility(8);
                        i.this.huH.removeView(next);
                    }
                    i.this.huF.clear();
                }
            }, 500L);
        }
    }

    public void cds() {
        this.handler.removeCallbacksAndMessages(null);
        this.loop = false;
        Iterator<HeadImageView> it = this.huF.iterator();
        while (it.hasNext()) {
            HeadImageView next = it.next();
            next.setVisibility(8);
            this.huH.removeView(next);
        }
        this.huF.clear();
    }

    public boolean cgj() {
        return this.huF.size() != 0;
    }

    private HeadImageView HZ(String str) {
        HeadImageView headImageView = new HeadImageView(this.context);
        headImageView.startLoad(str, 25, false, false);
        headImageView.setIsRound(true);
        headImageView.setAutoChangeStyle(false);
        headImageView.setVisibility(8);
        this.huH.addView(headImageView, this.huG);
        return headImageView;
    }

    private HeadImageView we(int i) {
        HeadImageView headImageView = new HeadImageView(this.context);
        if (i == 0) {
            headImageView.setImageResource(a.f.ala_icon_five_pointed_star);
        } else {
            headImageView.setImageResource(a.f.ala_icon_blank_five_pointed_star);
        }
        headImageView.setIsRound(true);
        headImageView.setAutoChangeStyle(false);
        headImageView.setVisibility(8);
        this.huH.addView(headImageView, this.huG);
        return headImageView;
    }
}
