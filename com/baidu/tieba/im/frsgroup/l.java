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
    private boolean eEA;
    private final MembersActivity eEw;
    private a eEx;
    private boolean eEy;
    private final Set<Long> eEB = new HashSet();
    private final List<UserData> eEC = new ArrayList();
    private ArrayList<IconData> eED = null;
    private boolean eEz = false;

    /* loaded from: classes3.dex */
    public interface a {
        void qb(int i);
    }

    public void a(a aVar) {
        this.eEx = aVar;
    }

    public void ci(List<UserData> list) {
        this.eEC.addAll(list);
    }

    public void cj(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.eEC.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void aJb() {
        this.eEB.clear();
    }

    public Set<Long> aJc() {
        return this.eEB;
    }

    public void f(Long l) {
        if (this.eEB.contains(l)) {
            this.eEB.remove(l);
        } else {
            this.eEB.add(l);
        }
        notifyDataSetChanged();
        if (this.eEx != null) {
            this.eEx.qb(this.eEB.size());
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.eEC.clear();
        }
        this.eEz = false;
        this.eEy = true;
    }

    public l(MembersActivity membersActivity) {
        this.eEw = membersActivity;
    }

    public void hy(boolean z) {
        this.eEy = z;
    }

    public boolean aml() {
        return this.eEy;
    }

    public void hz(boolean z) {
        this.eEz = z;
    }

    public boolean aGe() {
        return this.eEA;
    }

    public void hA(boolean z) {
        this.eEA = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eEC != null) {
            int size = this.eEC.size();
            if (this.eEz) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i >= this.eEC.size()) {
            return null;
        }
        return this.eEC.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eEz && i == getCount() - 1) {
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
        if (this.eEC != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.eEw.getPageContext().getPageActivity()).inflate(d.h.im_members_list_foot, viewGroup, false);
                    bVar2.eEF = (LinearLayout) inflate.findViewById(d.g.list_more);
                    bVar2.eEG = (TextView) inflate.findViewById(d.g.more_title);
                    bVar2.eEH = (ProgressBar) inflate.findViewById(d.g.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.eEw.getPageContext().getPageActivity()).inflate(d.h.im_members_list_item, viewGroup, false);
                    bVar2.eEJ = (HeadImageView) inflate2.findViewById(d.g.item_head);
                    bVar2.eEJ.setIsRound(false);
                    bVar2.eEJ.setAutoChangeStyle(true);
                    bVar2.eDy = (TextView) inflate2.findViewById(d.g.item_name);
                    bVar2.eEK = (ImageView) inflate2.findViewById(d.g.item_sex);
                    bVar2.eEL = (TextView) inflate2.findViewById(d.g.item_time);
                    bVar2.eEM = (TextView) inflate2.findViewById(d.g.item_address);
                    bVar2.eEI = (ImageView) inflate2.findViewById(d.g.item_check);
                    bVar2.beF = (UserIconBox) inflate2.findViewById(d.g.user_tshow_icon_box);
                    bVar2.eEN = inflate2.findViewById(d.g.list_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.eEy) {
                    bVar.eEG.setText(d.j.members_load_more_person);
                    bVar.eEH.setVisibility(0);
                } else {
                    bVar.eEG.setText(d.j.members_no_more_person);
                    bVar.eEH.setVisibility(8);
                }
            } else {
                TbadkApplication.getInst().getSkinType();
                UserData userData = (UserData) getItem(i);
                bVar.eEJ.setTag(null);
                String portrait = userData.getPortrait();
                if (!TextUtils.isEmpty(portrait)) {
                    bVar.eEJ.startLoad(portrait, 12, false);
                }
                bVar.eDy.setText(userData.getUserName());
                switch (userData.getSex()) {
                    case 1:
                        bVar.eEK.setVisibility(0);
                        aj.c(bVar.eEK, d.f.icon_pop_qz_boy);
                        break;
                    case 2:
                        bVar.eEK.setVisibility(0);
                        aj.c(bVar.eEK, d.f.icon_pop_qz_girl);
                        break;
                    default:
                        bVar.eEK.setVisibility(8);
                        break;
                }
                bVar.eEL.setText(d(userData));
                bVar.eEM.setText(userData.getPosition());
                this.eED = userData.getTShowInfo();
                if (bVar.beF != null) {
                    bVar.beF.a(this.eED, 2, this.eEw.getResources().getDimensionPixelSize(d.e.ds38), this.eEw.getResources().getDimensionPixelSize(d.e.ds38), this.eEw.getResources().getDimensionPixelSize(d.e.ds8), true);
                }
                if (this.eEA) {
                    bVar.eEI.setVisibility(userData.getPermission().isController() ? 4 : 0);
                    Long valueOf = Long.valueOf(userData.getUserIdLong());
                    bVar.eEI.setTag(valueOf);
                    bVar.eEI.setSelected(this.eEB.contains(valueOf));
                    bVar.eEI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            view3.setSelected(!view3.isSelected());
                            boolean isSelected = view3.isSelected();
                            Long l = (Long) view3.getTag();
                            if (isSelected) {
                                l.this.eEB.add(l);
                            } else {
                                l.this.eEB.remove(l);
                            }
                            if (l.this.eEx != null) {
                                l.this.eEx.qb(l.this.eEB.size());
                            }
                        }
                    });
                } else {
                    bVar.eEI.setVisibility(8);
                }
                bU(view);
            }
        }
        return view;
    }

    private void bU(View view) {
        this.eEw.getLayoutMode().aQ(TbadkApplication.getInst().getSkinType() == 1);
        this.eEw.getLayoutMode().aM(view);
    }

    private String d(UserData userData) {
        long lastReplyTime;
        MembersModel aIV = this.eEw.aIV();
        switch (aIV.getOrderType()) {
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
            if (aIV.getOrderType() == 1) {
                return this.eEw.getPageContext().getString(d.j.members_no_speak);
            }
            return "";
        }
        return am.e(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes3.dex */
    static class b {
        UserIconBox beF = null;
        TextView eDy;
        LinearLayout eEF;
        TextView eEG;
        ProgressBar eEH;
        ImageView eEI;
        HeadImageView eEJ;
        ImageView eEK;
        TextView eEL;
        TextView eEM;
        View eEN;

        b() {
        }
    }
}
