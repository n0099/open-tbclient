package com.baidu.tieba.group;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.view.GroupBannerView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class d extends BaseAdapter {
    private BaseFragment a;
    private int b = 0;
    private String c;
    private String d;

    public d(BaseFragment baseFragment) {
        this.a = baseFragment;
    }

    public void a(int i) {
        this.b = i;
        notifyDataSetChanged();
    }

    public void a(String str, String str2) {
        this.c = str;
        this.d = str2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return 7;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
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
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        switch (getItemViewType(i)) {
            case 0:
                return a(i, view, viewGroup);
            case 1:
                return b(i, view, viewGroup);
            case 2:
                return c(i, view, viewGroup);
            default:
                return view;
        }
    }

    private View c(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(TiebaApplication.h().getApplicationContext()).inflate(R.layout.group_tab_snap_door, viewGroup, false);
        Button button = (Button) inflate.findViewById(R.id.enter_chatroom);
        button.setTag(Integer.valueOf(i));
        button.setOnClickListener(this.a);
        bs.f((View) button, (int) R.drawable.btn_want_chat_selector);
        bs.a(button, R.color.group_chat_button_textcolor, 3);
        bs.a((TextView) inflate.findViewById(R.id.enter_chatroom_tip), R.color.group_chat_tip_textcolor, 1);
        return inflate;
    }

    public View a(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(TiebaApplication.h().getApplicationContext()).inflate(R.layout.group_tab_banner, viewGroup, false);
        GroupBannerView groupBannerView = (GroupBannerView) inflate.findViewById(R.id.group_banner);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.diver);
        if (!TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.d) && System.currentTimeMillis() - TiebaApplication.h().be() > 86400000) {
            bs.d(imageView, (int) R.drawable.divier_color);
            groupBannerView.a(this.c, this.d);
            groupBannerView.setVisibility(0);
            imageView.setVisibility(0);
        } else {
            groupBannerView.setVisibility(8);
            imageView.setVisibility(8);
        }
        return inflate;
    }

    public View b(int i, View view, ViewGroup viewGroup) {
        String str;
        e eVar = null;
        if (view != null) {
            eVar = (e) view.getTag();
        }
        if (eVar == null) {
            view = LayoutInflater.from(TiebaApplication.h().getApplicationContext()).inflate(R.layout.group_tab_item, viewGroup, false);
            eVar = a(view);
            view.setTag(eVar);
        }
        switch (i) {
            case 1:
                eVar.b.setVisibility(0);
                eVar.c.setVisibility(8);
                eVar.e.setVisibility(8);
                if (this.b <= 0) {
                    eVar.d.setText("附近群组");
                } else {
                    eVar.d.a("附近群组(" + this.b + ")", 5, str.length() - 1);
                }
                eVar.d.setLeftIconRes(R.drawable.icon_nearby_group);
                break;
            case 2:
                eVar.b.setVisibility(8);
                eVar.c.setVisibility(0);
                eVar.e.setVisibility(0);
                eVar.d.setText(TiebaApplication.h().getResources().getString(R.string.group_tab_hotgroup));
                eVar.d.setLeftIconRes(R.drawable.icon_hot_group);
                break;
            case 3:
                eVar.b.setVisibility(0);
                eVar.c.setVisibility(8);
                eVar.e.setVisibility(8);
                eVar.d.setText(TiebaApplication.h().getResources().getString(R.string.group_tab_mygroup));
                eVar.d.setLeftIconRes(R.drawable.icon_me_group);
                break;
            case 4:
                eVar.b.setVisibility(8);
                eVar.c.setVisibility(0);
                eVar.e.setVisibility(8);
                eVar.d.setText(TiebaApplication.h().getResources().getString(R.string.group_tab_addgroup));
                eVar.d.setLeftIconRes(R.drawable.icon_add_group);
                break;
            case 5:
                eVar.b.setVisibility(8);
                eVar.c.setVisibility(0);
                eVar.e.setVisibility(0);
                eVar.d.setText(TiebaApplication.h().getResources().getString(R.string.group_tab_quick_response));
                eVar.d.setLeftIconRes(R.drawable.icon_qr_code);
                break;
        }
        eVar.d.setTag(Integer.valueOf(i));
        bs.d(eVar.b, (int) R.drawable.divier_color);
        bs.d(eVar.c, (int) R.drawable.divier_color);
        bs.f(eVar.c, (int) R.color.mygroup_bg);
        bs.d(eVar.e, (int) R.drawable.divier_color);
        bs.f(eVar.d, (int) R.drawable.square_list_item_selector);
        bs.f(eVar.a, (int) R.color.bg_page_setting);
        eVar.d.a(TiebaApplication.h().al());
        eVar.d.setOnClickListener(this.a);
        bs.a(eVar.d.getTextView(), R.color.listview_item_title_text, 1);
        bs.d(eVar.d.getRightIcon(), (int) R.drawable.icon_ba_top_arrow_big);
        return view;
    }

    private e a(View view) {
        e eVar = new e();
        eVar.b = (ImageView) view.findViewById(R.id.diver_have_space);
        eVar.c = (ImageView) view.findViewById(R.id.diver_no_space);
        eVar.d = (GroupTabWidget) view.findViewById(R.id.text_widget);
        eVar.e = (ImageView) view.findViewById(R.id.diver_bottom);
        return eVar;
    }

    public void b(int i) {
        notifyDataSetChanged();
    }
}
