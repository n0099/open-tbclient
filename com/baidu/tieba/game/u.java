package com.baidu.tieba.game;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class u extends BaseAdapter {
    private List<UserData> aHm = new ArrayList();
    private Context mContext;

    public void F(List<UserData> list) {
        this.aHm.addAll(list);
    }

    public u(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aHm != null) {
            return ((this.aHm.size() * 2) - 1) + 2;
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: fb */
    public UserData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.aHm.size()) {
            return null;
        }
        return this.aHm.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        int i2;
        if (i == 0) {
            return -2L;
        }
        if (i == getCount() - 1) {
            return -3L;
        }
        if ((i - 1) % 2 == 0) {
            return i2 / 2;
        }
        return -1L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        long itemId = getItemId(i);
        if (itemId >= 0) {
            return 0;
        }
        if (itemId == -1) {
            return 1;
        }
        if (itemId == -2) {
            return 2;
        }
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 4;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        v vVar;
        UserData item;
        View a;
        if (this.aHm != null) {
            if (view == null) {
                v vVar2 = new v();
                if (getItemViewType(i) == 1) {
                    a = com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.game_detail_rank_list_line, viewGroup, false);
                } else if (getItemViewType(i) == 2 || getItemViewType(i) == 3) {
                    a = com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.game_detail_rank_list_space, viewGroup, false);
                } else {
                    View a2 = com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.game_detial_rank_list_item, viewGroup, false);
                    vVar2.aHn = (ViewGroup) a2.findViewById(com.baidu.tieba.v.list_item);
                    vVar2.aHo = (TextView) a2.findViewById(com.baidu.tieba.v.item_order);
                    vVar2.aHp = (HeadImageView) a2.findViewById(com.baidu.tieba.v.item_head);
                    vVar2.aHq = (TextView) a2.findViewById(com.baidu.tieba.v.item_name);
                    vVar2.aHr = (TextView) a2.findViewById(com.baidu.tieba.v.item_grade);
                    a = a2;
                }
                a.setTag(vVar2);
                view = a;
                vVar = vVar2;
            } else {
                vVar = (v) view.getTag();
            }
            if (getItemViewType(i) == 0 && (item = getItem(i)) != null) {
                c(vVar.aHn, i);
                o(vVar.aHo, i);
                String portrait = item.getPortrait();
                if (!TextUtils.isEmpty(portrait)) {
                    vVar.aHp.c(portrait, 12, false);
                } else {
                    vVar.aHp.c(null, 12, false);
                }
                vVar.aHq.setText(item.getUserName());
                a(vVar.aHr, item.getGrade());
            }
            F(view);
        }
        return view;
    }

    private void a(TextView textView, String str) {
        textView.setText(UtilHelper.formatNumber(str));
    }

    private void o(TextView textView, int i) {
        int i2 = (i - 1) / 2;
        switch (i2) {
            case 0:
                textView.setText("");
                com.baidu.tbadk.core.util.aw.h((View) textView, com.baidu.tieba.u.icon_ranking_no1);
                return;
            case 1:
                textView.setText("");
                com.baidu.tbadk.core.util.aw.h((View) textView, com.baidu.tieba.u.icon_ranking_no2);
                return;
            case 2:
                textView.setText("");
                com.baidu.tbadk.core.util.aw.h((View) textView, com.baidu.tieba.u.icon_ranking_no3);
                return;
            default:
                int i3 = i2 + 1;
                if (i3 < 10) {
                    textView.setTextSize(0, com.baidu.adp.lib.util.m.c(this.mContext, com.baidu.tieba.t.ds32));
                } else {
                    textView.setTextSize(0, com.baidu.adp.lib.util.m.c(this.mContext, com.baidu.tieba.t.ds30));
                }
                textView.setText(String.valueOf(i3));
                com.baidu.tbadk.core.util.aw.h((View) textView, com.baidu.tieba.u.icon_ranking_no);
                return;
        }
    }

    private void c(ViewGroup viewGroup, int i) {
        int i2 = (i - 1) / 2;
        String userId = getItem(i).getUserId();
        boolean z = !TextUtils.isEmpty(userId) && userId.equals(TbadkApplication.getCurrentAccount());
        if (this.aHm.size() == 1) {
            com.baidu.tbadk.core.util.aw.h(viewGroup, com.baidu.tieba.u.list_item_selector_gamedetail_rand_full);
        } else if (i2 == 0) {
            if (z) {
                com.baidu.tbadk.core.util.aw.h(viewGroup, com.baidu.tieba.u.list_item_selector_game_detail_rand_self_top);
            } else {
                com.baidu.tbadk.core.util.aw.h(viewGroup, com.baidu.tieba.u.list_item_selector_gamedetail_rand_top);
            }
        } else if (i2 == this.aHm.size() - 1) {
            if (z) {
                com.baidu.tbadk.core.util.aw.h(viewGroup, com.baidu.tieba.u.list_item_selector_game_detail_rand_self_bottom);
            } else {
                com.baidu.tbadk.core.util.aw.h(viewGroup, com.baidu.tieba.u.list_item_selector_gamedetail_rand_bottom);
            }
        } else if (z) {
            com.baidu.tbadk.core.util.aw.h(viewGroup, com.baidu.tieba.u.list_item_selector_game_detail_rand_self_middle);
        } else {
            com.baidu.tbadk.core.util.aw.h(viewGroup, com.baidu.tieba.u.list_item_selector_gamedetail_rand_middle);
        }
    }

    private void F(View view) {
        int skinType = TbadkApplication.m251getInst().getSkinType();
        if (this.mContext instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) this.mContext;
            baseActivity.getLayoutMode().L(skinType == 1);
            baseActivity.getLayoutMode().h(view);
        } else if (this.mContext instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.mContext;
            baseFragmentActivity.getLayoutMode().L(skinType == 1);
            baseFragmentActivity.getLayoutMode().h(view);
        }
    }
}
