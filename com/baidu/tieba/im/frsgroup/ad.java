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
import com.baidu.tbadk.core.util.az;
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
    private final MembersActivity aYf;
    private af aYg;
    private boolean aYi;
    private boolean ayV;
    private final Set<Long> aYj = new HashSet();
    private final List<UserData> aHw = new ArrayList();
    private ArrayList<IconData> ayZ = null;
    private boolean aYh = false;

    public void a(af afVar) {
        this.aYg = afVar;
    }

    public void F(List<UserData> list) {
        this.aHw.addAll(list);
    }

    public void W(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.aHw.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void NL() {
        this.aYj.clear();
    }

    public Set<Long> NM() {
        return this.aYj;
    }

    public void a(Long l) {
        if (this.aYj.contains(l)) {
            this.aYj.remove(l);
        } else {
            this.aYj.add(l);
        }
        notifyDataSetChanged();
        if (this.aYg != null) {
            this.aYg.fI(this.aYj.size());
        }
    }

    public void bM(boolean z) {
        if (z) {
            this.aHw.clear();
        }
        this.aYh = false;
        this.ayV = true;
    }

    public ad(MembersActivity membersActivity) {
        this.aYf = membersActivity;
    }

    public void bO(boolean z) {
        this.ayV = z;
    }

    public boolean EL() {
        return this.ayV;
    }

    public void cY(boolean z) {
        this.aYh = z;
    }

    public boolean NN() {
        return this.aYi;
    }

    public void cZ(boolean z) {
        this.aYi = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aHw != null) {
            int size = this.aHw.size();
            if (this.aYh) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i >= this.aHw.size()) {
            return null;
        }
        return this.aHw.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aYh && i == getCount() - 1) {
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
        if (this.aHw != null) {
            if (view == null) {
                ag agVar2 = new ag();
                if (getItemViewType(i) == 1) {
                    View a = com.baidu.adp.lib.g.b.ek().a(this.aYf, com.baidu.tieba.w.im_members_list_foot, viewGroup, false);
                    agVar2.azi = (LinearLayout) a.findViewById(com.baidu.tieba.v.list_more);
                    agVar2.azj = (TextView) a.findViewById(com.baidu.tieba.v.more_title);
                    agVar2.azk = (ProgressBar) a.findViewById(com.baidu.tieba.v.more_progress);
                    view2 = a;
                } else {
                    View a2 = com.baidu.adp.lib.g.b.ek().a(this.aYf, com.baidu.tieba.w.im_members_list_item, viewGroup, false);
                    agVar2.aYm = (HeadImageView) a2.findViewById(com.baidu.tieba.v.item_head);
                    agVar2.aYm.setIsRound(false);
                    agVar2.aYm.setAutoChangeStyle(true);
                    agVar2.aWI = (TextView) a2.findViewById(com.baidu.tieba.v.item_name);
                    agVar2.aYn = (ImageView) a2.findViewById(com.baidu.tieba.v.item_sex);
                    agVar2.aYo = (TextView) a2.findViewById(com.baidu.tieba.v.item_time);
                    agVar2.aYp = (TextView) a2.findViewById(com.baidu.tieba.v.item_address);
                    agVar2.aYl = (ImageView) a2.findViewById(com.baidu.tieba.v.item_check);
                    agVar2.azs = (UserIconBox) a2.findViewById(com.baidu.tieba.v.user_tshow_icon_box);
                    agVar2.aYq = a2.findViewById(com.baidu.tieba.v.list_line);
                    view2 = a2;
                }
                view2.setTag(agVar2);
                agVar = agVar2;
                view = view2;
            } else {
                agVar = (ag) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.ayV) {
                    agVar.azj.setText(com.baidu.tieba.y.members_load_more_person);
                    agVar.azk.setVisibility(0);
                } else {
                    agVar.azj.setText(com.baidu.tieba.y.members_no_more_person);
                    agVar.azk.setVisibility(8);
                }
            } else {
                TbadkApplication.m251getInst().getSkinType();
                UserData userData = (UserData) getItem(i);
                agVar.aYm.setTag(null);
                String portrait = userData.getPortrait();
                if (!TextUtils.isEmpty(portrait)) {
                    agVar.aYm.c(portrait, 12, false);
                }
                agVar.aWI.setText(userData.getUserName());
                switch (userData.getSex()) {
                    case 1:
                        agVar.aYn.setVisibility(0);
                        aw.c(agVar.aYn, com.baidu.tieba.u.icon_pop_qz_boy);
                        break;
                    case 2:
                        agVar.aYn.setVisibility(0);
                        aw.c(agVar.aYn, com.baidu.tieba.u.icon_pop_qz_girl);
                        break;
                    default:
                        agVar.aYn.setVisibility(8);
                        break;
                }
                agVar.aYo.setText(b(userData));
                agVar.aYp.setText(userData.getPosition());
                this.ayZ = userData.getTShowInfo();
                if (agVar.azs != null) {
                    agVar.azs.a(this.ayZ, 2, this.aYf.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_width), this.aYf.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_height), this.aYf.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_margin), true);
                }
                if (this.aYi) {
                    agVar.aYl.setVisibility(userData.getPermission().isController() ? 4 : 0);
                    Long valueOf = Long.valueOf(userData.getUserIdLong());
                    agVar.aYl.setTag(valueOf);
                    agVar.aYl.setSelected(this.aYj.contains(valueOf));
                    agVar.aYl.setOnClickListener(new ae(this));
                } else {
                    agVar.aYl.setVisibility(8);
                }
                F(view);
            }
        }
        return view;
    }

    private void F(View view) {
        this.aYf.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.aYf.getLayoutMode().h(view);
    }

    private String b(UserData userData) {
        long lastReplyTime;
        MembersModel NF = this.aYf.NF();
        switch (NF.getOrderType()) {
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
            if (NF.getOrderType() == 1) {
                return this.aYf.getString(com.baidu.tieba.y.members_no_speak);
            }
            return "";
        }
        return az.f(new Date(lastReplyTime * 1000));
    }
}
