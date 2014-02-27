package com.baidu.tieba.group;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.j;
import com.baidu.tieba.util.bq;
import com.baidu.tieba.view.GroupBannerView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class e extends BaseAdapter {
    private j a;
    private int b = 0;
    private String c;
    private String d;

    public e(j jVar) {
        this.a = jVar;
    }

    public final void a(int i) {
        this.b = i;
        notifyDataSetChanged();
    }

    public final void a(String str, String str2) {
        this.c = str;
        this.d = str2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return 7;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            default:
                return 1;
            case 6:
                return 2;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        String str;
        switch (getItemViewType(i)) {
            case 0:
                View inflate = LayoutInflater.from(TiebaApplication.g().b().getApplicationContext()).inflate(R.layout.group_tab_banner, viewGroup, false);
                GroupBannerView groupBannerView = (GroupBannerView) inflate.findViewById(R.id.group_banner);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.diver);
                if (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.d) || System.currentTimeMillis() - TiebaApplication.g().aT() <= 259200000) {
                    groupBannerView.setVisibility(8);
                    imageView.setVisibility(8);
                    return inflate;
                }
                bq.d(imageView, (int) R.drawable.divier_color);
                groupBannerView.a(this.c, this.d);
                groupBannerView.setVisibility(0);
                imageView.setVisibility(0);
                return inflate;
            case 1:
                f fVar = view != null ? (f) view.getTag() : null;
                if (fVar == null) {
                    view = LayoutInflater.from(TiebaApplication.g().b().getApplicationContext()).inflate(R.layout.group_tab_item, viewGroup, false);
                    f fVar2 = new f();
                    fVar2.b = (ImageView) view.findViewById(R.id.diver_have_space);
                    fVar2.c = (ImageView) view.findViewById(R.id.diver_no_space);
                    fVar2.d = (GroupTabWidget) view.findViewById(R.id.text_widget);
                    fVar2.e = (ImageView) view.findViewById(R.id.diver_bottom);
                    view.setTag(fVar2);
                    fVar = fVar2;
                }
                switch (i) {
                    case 1:
                        fVar.b.setVisibility(0);
                        fVar.c.setVisibility(8);
                        fVar.e.setVisibility(8);
                        if (this.b <= 0) {
                            fVar.d.setText("附近群组");
                        } else {
                            fVar.d.a("附近群组(" + this.b + ")", 5, str.length() - 1);
                        }
                        fVar.d.setLeftIconRes(R.drawable.icon_nearby_group);
                        break;
                    case 2:
                        fVar.b.setVisibility(8);
                        fVar.c.setVisibility(0);
                        fVar.e.setVisibility(0);
                        fVar.d.setText(TiebaApplication.g().b().getResources().getString(R.string.group_tab_hotgroup));
                        fVar.d.setLeftIconRes(R.drawable.icon_hot_group);
                        break;
                    case 3:
                        fVar.b.setVisibility(0);
                        fVar.c.setVisibility(8);
                        fVar.e.setVisibility(8);
                        fVar.d.setText(TiebaApplication.g().b().getResources().getString(R.string.group_tab_mygroup));
                        fVar.d.setLeftIconRes(R.drawable.icon_me_group);
                        break;
                    case 4:
                        fVar.b.setVisibility(8);
                        fVar.c.setVisibility(0);
                        fVar.e.setVisibility(8);
                        fVar.d.setText(TiebaApplication.g().b().getResources().getString(R.string.group_tab_addgroup));
                        fVar.d.setLeftIconRes(R.drawable.icon_add_group);
                        break;
                    case 5:
                        fVar.b.setVisibility(8);
                        fVar.c.setVisibility(0);
                        fVar.e.setVisibility(0);
                        fVar.d.setText(TiebaApplication.g().b().getResources().getString(R.string.group_tab_quick_response));
                        fVar.d.setLeftIconRes(R.drawable.icon_qr_code);
                        break;
                }
                fVar.d.setTag(Integer.valueOf(i));
                bq.d(fVar.b, (int) R.drawable.divier_color);
                bq.d(fVar.c, (int) R.drawable.divier_color);
                bq.f(fVar.c, (int) R.color.mygroup_bg);
                bq.d(fVar.e, (int) R.drawable.divier_color);
                bq.f(fVar.d, (int) R.drawable.square_list_item_selector);
                bq.f(fVar.a, (int) R.color.bg_page_setting);
                fVar.d.a(TiebaApplication.g().ae());
                fVar.d.setOnClickListener(this.a);
                bq.a(fVar.d.getTextView(), R.color.listview_item_title_text, 1);
                bq.d(fVar.d.getRightIcon(), (int) R.drawable.icon_ba_top_arrow_big);
                return view;
            case 2:
                View inflate2 = LayoutInflater.from(TiebaApplication.g().b().getApplicationContext()).inflate(R.layout.group_tab_snap_door, viewGroup, false);
                Button button = (Button) inflate2.findViewById(R.id.enter_chatroom);
                button.setTag(Integer.valueOf(i));
                button.setOnClickListener(this.a);
                bq.f((View) button, (int) R.drawable.btn_want_chat_selector);
                bq.a(button, R.color.group_chat_button_textcolor, 3);
                bq.a((TextView) inflate2.findViewById(R.id.enter_chatroom_tip), R.color.group_chat_tip_textcolor, 1);
                return inflate2;
            default:
                return view;
        }
    }

    public final void a() {
        notifyDataSetChanged();
    }
}
