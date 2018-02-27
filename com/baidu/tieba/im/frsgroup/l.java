package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.d;
import com.baidu.tieba.im.model.MembersModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class l extends BaseAdapter {
    private final MembersActivity eEk;
    private a eEl;
    private boolean eEm;
    private boolean eEo;
    private final Set<Long> eEp = new HashSet();
    private final List<UserData> eEq = new ArrayList();
    private ArrayList<IconData> eEr = null;
    private boolean eEn = false;

    /* loaded from: classes3.dex */
    public interface a {
        void qb(int i);
    }

    public void a(a aVar) {
        this.eEl = aVar;
    }

    public void ci(List<UserData> list) {
        this.eEq.addAll(list);
    }

    public void cj(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.eEq.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void aJa() {
        this.eEp.clear();
    }

    public Set<Long> aJb() {
        return this.eEp;
    }

    public void f(Long l) {
        if (this.eEp.contains(l)) {
            this.eEp.remove(l);
        } else {
            this.eEp.add(l);
        }
        notifyDataSetChanged();
        if (this.eEl != null) {
            this.eEl.qb(this.eEp.size());
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.eEq.clear();
        }
        this.eEn = false;
        this.eEm = true;
    }

    public l(MembersActivity membersActivity) {
        this.eEk = membersActivity;
    }

    public void hy(boolean z) {
        this.eEm = z;
    }

    public boolean amk() {
        return this.eEm;
    }

    public void hz(boolean z) {
        this.eEn = z;
    }

    public boolean aGd() {
        return this.eEo;
    }

    public void hA(boolean z) {
        this.eEo = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eEq != null) {
            int size = this.eEq.size();
            if (this.eEn) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i >= this.eEq.size()) {
            return null;
        }
        return this.eEq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eEn && i == getCount() - 1) {
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
        b bVar;
        View view2;
        if (this.eEq != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.eEk.getPageContext().getPageActivity()).inflate(d.h.im_members_list_foot, viewGroup, false);
                    bVar2.eEt = (LinearLayout) inflate.findViewById(d.g.list_more);
                    bVar2.eEu = (TextView) inflate.findViewById(d.g.more_title);
                    bVar2.eEv = (ProgressBar) inflate.findViewById(d.g.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.eEk.getPageContext().getPageActivity()).inflate(d.h.im_members_list_item, viewGroup, false);
                    bVar2.eEx = (HeadImageView) inflate2.findViewById(d.g.item_head);
                    bVar2.eEx.setIsRound(false);
                    bVar2.eEx.setAutoChangeStyle(true);
                    bVar2.eDm = (TextView) inflate2.findViewById(d.g.item_name);
                    bVar2.eEy = (ImageView) inflate2.findViewById(d.g.item_sex);
                    bVar2.eEz = (TextView) inflate2.findViewById(d.g.item_time);
                    bVar2.eEA = (TextView) inflate2.findViewById(d.g.item_address);
                    bVar2.eEw = (ImageView) inflate2.findViewById(d.g.item_check);
                    bVar2.bes = (UserIconBox) inflate2.findViewById(d.g.user_tshow_icon_box);
                    bVar2.eEB = inflate2.findViewById(d.g.list_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.eEm) {
                    bVar.eEu.setText(d.j.members_load_more_person);
                    bVar.eEv.setVisibility(0);
                } else {
                    bVar.eEu.setText(d.j.members_no_more_person);
                    bVar.eEv.setVisibility(8);
                }
            } else {
                TbadkApplication.getInst().getSkinType();
                UserData userData = (UserData) getItem(i);
                bVar.eEx.setTag(null);
                String portrait = userData.getPortrait();
                if (!TextUtils.isEmpty(portrait)) {
                    bVar.eEx.startLoad(portrait, 12, false);
                }
                bVar.eDm.setText(userData.getUserName());
                switch (userData.getSex()) {
                    case 1:
                        bVar.eEy.setVisibility(0);
                        aj.c(bVar.eEy, d.f.icon_pop_qz_boy);
                        break;
                    case 2:
                        bVar.eEy.setVisibility(0);
                        aj.c(bVar.eEy, d.f.icon_pop_qz_girl);
                        break;
                    default:
                        bVar.eEy.setVisibility(8);
                        break;
                }
                bVar.eEz.setText(d(userData));
                bVar.eEA.setText(userData.getPosition());
                this.eEr = userData.getTShowInfo();
                if (bVar.bes != null) {
                    bVar.bes.a(this.eEr, 2, this.eEk.getResources().getDimensionPixelSize(d.e.ds38), this.eEk.getResources().getDimensionPixelSize(d.e.ds38), this.eEk.getResources().getDimensionPixelSize(d.e.ds8), true);
                }
                if (this.eEo) {
                    bVar.eEw.setVisibility(userData.getPermission().isController() ? 4 : 0);
                    Long valueOf = Long.valueOf(userData.getUserIdLong());
                    bVar.eEw.setTag(valueOf);
                    bVar.eEw.setSelected(this.eEp.contains(valueOf));
                    bVar.eEw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            view3.setSelected(!view3.isSelected());
                            boolean isSelected = view3.isSelected();
                            Long l = (Long) view3.getTag();
                            if (isSelected) {
                                l.this.eEp.add(l);
                            } else {
                                l.this.eEp.remove(l);
                            }
                            if (l.this.eEl != null) {
                                l.this.eEl.qb(l.this.eEp.size());
                            }
                        }
                    });
                } else {
                    bVar.eEw.setVisibility(8);
                }
                bU(view);
            }
        }
        return view;
    }

    private void bU(View view) {
        this.eEk.getLayoutMode().aQ(TbadkApplication.getInst().getSkinType() == 1);
        this.eEk.getLayoutMode().aM(view);
    }

    private String d(UserData userData) {
        long lastReplyTime;
        MembersModel aIU = this.eEk.aIU();
        switch (aIU.getOrderType()) {
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
            if (aIU.getOrderType() == 1) {
                return this.eEk.getPageContext().getString(d.j.members_no_speak);
            }
            return "";
        }
        return am.e(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes3.dex */
    static class b {
        UserIconBox bes = null;
        TextView eDm;
        TextView eEA;
        View eEB;
        LinearLayout eEt;
        TextView eEu;
        ProgressBar eEv;
        ImageView eEw;
        HeadImageView eEx;
        ImageView eEy;
        TextView eEz;

        b() {
        }
    }
}
