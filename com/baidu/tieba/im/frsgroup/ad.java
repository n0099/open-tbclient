package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.im.model.MembersModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class ad extends BaseAdapter {
    private final MembersActivity aXR;
    private af aXS;
    private boolean aXU;
    private boolean ayM;
    private final Set<Long> aXV = new HashSet();
    private final List<UserData> aHm = new ArrayList();
    private ArrayList<IconData> ayQ = null;
    private boolean aXT = false;

    public void a(af afVar) {
        this.aXS = afVar;
    }

    public void F(List<UserData> list) {
        this.aHm.addAll(list);
    }

    public void W(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.aHm.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void NH() {
        this.aXV.clear();
    }

    public Set<Long> NI() {
        return this.aXV;
    }

    public void a(Long l) {
        if (this.aXV.contains(l)) {
            this.aXV.remove(l);
        } else {
            this.aXV.add(l);
        }
        notifyDataSetChanged();
        if (this.aXS != null) {
            this.aXS.fI(this.aXV.size());
        }
    }

    public void bM(boolean z) {
        if (z) {
            this.aHm.clear();
        }
        this.aXT = false;
        this.ayM = true;
    }

    public ad(MembersActivity membersActivity) {
        this.aXR = membersActivity;
    }

    public void bO(boolean z) {
        this.ayM = z;
    }

    public boolean EJ() {
        return this.ayM;
    }

    public void cY(boolean z) {
        this.aXT = z;
    }

    public boolean NJ() {
        return this.aXU;
    }

    public void cZ(boolean z) {
        this.aXU = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aHm != null) {
            int size = this.aHm.size();
            if (this.aXT) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i >= this.aHm.size()) {
            return null;
        }
        return this.aHm.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aXT && i == getCount() - 1) {
            return -2L;
        }
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ag agVar;
        View view2;
        if (this.aHm != null) {
            if (view == null) {
                ag agVar2 = new ag();
                if (getItemViewType(i) == 1) {
                    View a = com.baidu.adp.lib.g.b.ek().a(this.aXR, com.baidu.tieba.w.im_members_list_foot, viewGroup, false);
                    agVar2.ayZ = (LinearLayout) a.findViewById(com.baidu.tieba.v.list_more);
                    agVar2.aza = (TextView) a.findViewById(com.baidu.tieba.v.more_title);
                    agVar2.azb = (ProgressBar) a.findViewById(com.baidu.tieba.v.more_progress);
                    view2 = a;
                } else {
                    View a2 = com.baidu.adp.lib.g.b.ek().a(this.aXR, com.baidu.tieba.w.im_members_list_item, viewGroup, false);
                    agVar2.aXY = (HeadImageView) a2.findViewById(com.baidu.tieba.v.item_head);
                    agVar2.aXY.setIsRound(false);
                    agVar2.aXY.setAutoChangeStyle(true);
                    agVar2.aWu = (TextView) a2.findViewById(com.baidu.tieba.v.item_name);
                    agVar2.aXZ = (ImageView) a2.findViewById(com.baidu.tieba.v.item_sex);
                    agVar2.aYa = (TextView) a2.findViewById(com.baidu.tieba.v.item_time);
                    agVar2.aYb = (TextView) a2.findViewById(com.baidu.tieba.v.item_address);
                    agVar2.aXX = (ImageView) a2.findViewById(com.baidu.tieba.v.item_check);
                    agVar2.azj = (UserIconBox) a2.findViewById(com.baidu.tieba.v.user_tshow_icon_box);
                    agVar2.aYc = a2.findViewById(com.baidu.tieba.v.list_line);
                    view2 = a2;
                }
                view2.setTag(agVar2);
                agVar = agVar2;
                view = view2;
            } else {
                agVar = (ag) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.ayM) {
                    agVar.aza.setText(com.baidu.tieba.y.members_load_more_person);
                    agVar.azb.setVisibility(0);
                } else {
                    agVar.aza.setText(com.baidu.tieba.y.members_no_more_person);
                    agVar.azb.setVisibility(8);
                }
            } else {
                TbadkApplication.m251getInst().getSkinType();
                UserData userData = (UserData) getItem(i);
                agVar.aXY.setTag(null);
                String portrait = userData.getPortrait();
                if (!TextUtils.isEmpty(portrait)) {
                    agVar.aXY.c(portrait, 12, false);
                }
                agVar.aWu.setText(userData.getUserName());
                switch (userData.getSex()) {
                    case 1:
                        agVar.aXZ.setVisibility(0);
                        aw.c(agVar.aXZ, com.baidu.tieba.u.icon_pop_qz_boy);
                        break;
                    case 2:
                        agVar.aXZ.setVisibility(0);
                        aw.c(agVar.aXZ, com.baidu.tieba.u.icon_pop_qz_girl);
                        break;
                    default:
                        agVar.aXZ.setVisibility(8);
                        break;
                }
                agVar.aYa.setText(b(userData));
                agVar.aYb.setText(userData.getPosition());
                this.ayQ = userData.getTShowInfo();
                if (agVar.azj != null) {
                    agVar.azj.a(this.ayQ, 2, this.aXR.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_width), this.aXR.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_height), this.aXR.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_margin), true);
                }
                if (this.aXU) {
                    agVar.aXX.setVisibility(userData.getPermission().isController() ? 4 : 0);
                    Long valueOf = Long.valueOf(userData.getUserIdLong());
                    agVar.aXX.setTag(valueOf);
                    agVar.aXX.setSelected(this.aXV.contains(valueOf));
                    agVar.aXX.setOnClickListener(new ae(this));
                } else {
                    agVar.aXX.setVisibility(8);
                }
                F(view);
            }
        }
        return view;
    }

    private void F(View view) {
        this.aXR.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.aXR.getLayoutMode().h(view);
    }

    private String b(UserData userData) {
        long lastReplyTime;
        MembersModel NB = this.aXR.NB();
        switch (NB.getOrderType()) {
            case 0:
                lastReplyTime = userData.getLoginTime();
                break;
            case 1:
                lastReplyTime = userData.getLastReplyTime();
                break;
            case 2:
                lastReplyTime = userData.getInTime();
                break;
            default:
                lastReplyTime = 0;
                break;
        }
        if (lastReplyTime <= 0) {
            if (NB.getOrderType() == 1) {
                return this.aXR.getString(com.baidu.tieba.y.members_no_speak);
            }
            return "";
        }
        return ay.f(new Date(lastReplyTime * 1000));
    }
}
