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
    private final MembersActivity eEA;
    private a eEB;
    private boolean eEC;
    private boolean eEE;
    private final Set<Long> eEF = new HashSet();
    private final List<UserData> eEG = new ArrayList();
    private ArrayList<IconData> eEH = null;
    private boolean eED = false;

    /* loaded from: classes3.dex */
    public interface a {
        void qc(int i);
    }

    public void a(a aVar) {
        this.eEB = aVar;
    }

    public void ci(List<UserData> list) {
        this.eEG.addAll(list);
    }

    public void cj(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.eEG.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void aJb() {
        this.eEF.clear();
    }

    public Set<Long> aJc() {
        return this.eEF;
    }

    public void f(Long l) {
        if (this.eEF.contains(l)) {
            this.eEF.remove(l);
        } else {
            this.eEF.add(l);
        }
        notifyDataSetChanged();
        if (this.eEB != null) {
            this.eEB.qc(this.eEF.size());
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.eEG.clear();
        }
        this.eED = false;
        this.eEC = true;
    }

    public l(MembersActivity membersActivity) {
        this.eEA = membersActivity;
    }

    public void hD(boolean z) {
        this.eEC = z;
    }

    public boolean aml() {
        return this.eEC;
    }

    public void hE(boolean z) {
        this.eED = z;
    }

    public boolean aGe() {
        return this.eEE;
    }

    public void hF(boolean z) {
        this.eEE = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eEG != null) {
            int size = this.eEG.size();
            if (this.eED) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i >= this.eEG.size()) {
            return null;
        }
        return this.eEG.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eED && i == getCount() - 1) {
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
        if (this.eEG != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.eEA.getPageContext().getPageActivity()).inflate(d.h.im_members_list_foot, viewGroup, false);
                    bVar2.eEJ = (LinearLayout) inflate.findViewById(d.g.list_more);
                    bVar2.eEK = (TextView) inflate.findViewById(d.g.more_title);
                    bVar2.eEL = (ProgressBar) inflate.findViewById(d.g.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.eEA.getPageContext().getPageActivity()).inflate(d.h.im_members_list_item, viewGroup, false);
                    bVar2.eEN = (HeadImageView) inflate2.findViewById(d.g.item_head);
                    bVar2.eEN.setIsRound(false);
                    bVar2.eEN.setAutoChangeStyle(true);
                    bVar2.eDC = (TextView) inflate2.findViewById(d.g.item_name);
                    bVar2.eEO = (ImageView) inflate2.findViewById(d.g.item_sex);
                    bVar2.eEP = (TextView) inflate2.findViewById(d.g.item_time);
                    bVar2.eEQ = (TextView) inflate2.findViewById(d.g.item_address);
                    bVar2.eEM = (ImageView) inflate2.findViewById(d.g.item_check);
                    bVar2.bew = (UserIconBox) inflate2.findViewById(d.g.user_tshow_icon_box);
                    bVar2.eER = inflate2.findViewById(d.g.list_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.eEC) {
                    bVar.eEK.setText(d.j.members_load_more_person);
                    bVar.eEL.setVisibility(0);
                } else {
                    bVar.eEK.setText(d.j.members_no_more_person);
                    bVar.eEL.setVisibility(8);
                }
            } else {
                TbadkApplication.getInst().getSkinType();
                UserData userData = (UserData) getItem(i);
                bVar.eEN.setTag(null);
                String portrait = userData.getPortrait();
                if (!TextUtils.isEmpty(portrait)) {
                    bVar.eEN.startLoad(portrait, 12, false);
                }
                bVar.eDC.setText(userData.getUserName());
                switch (userData.getSex()) {
                    case 1:
                        bVar.eEO.setVisibility(0);
                        aj.c(bVar.eEO, d.f.icon_pop_qz_boy);
                        break;
                    case 2:
                        bVar.eEO.setVisibility(0);
                        aj.c(bVar.eEO, d.f.icon_pop_qz_girl);
                        break;
                    default:
                        bVar.eEO.setVisibility(8);
                        break;
                }
                bVar.eEP.setText(d(userData));
                bVar.eEQ.setText(userData.getPosition());
                this.eEH = userData.getTShowInfo();
                if (bVar.bew != null) {
                    bVar.bew.a(this.eEH, 2, this.eEA.getResources().getDimensionPixelSize(d.e.ds38), this.eEA.getResources().getDimensionPixelSize(d.e.ds38), this.eEA.getResources().getDimensionPixelSize(d.e.ds8), true);
                }
                if (this.eEE) {
                    bVar.eEM.setVisibility(userData.getPermission().isController() ? 4 : 0);
                    Long valueOf = Long.valueOf(userData.getUserIdLong());
                    bVar.eEM.setTag(valueOf);
                    bVar.eEM.setSelected(this.eEF.contains(valueOf));
                    bVar.eEM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            view3.setSelected(!view3.isSelected());
                            boolean isSelected = view3.isSelected();
                            Long l = (Long) view3.getTag();
                            if (isSelected) {
                                l.this.eEF.add(l);
                            } else {
                                l.this.eEF.remove(l);
                            }
                            if (l.this.eEB != null) {
                                l.this.eEB.qc(l.this.eEF.size());
                            }
                        }
                    });
                } else {
                    bVar.eEM.setVisibility(8);
                }
                bU(view);
            }
        }
        return view;
    }

    private void bU(View view) {
        this.eEA.getLayoutMode().aQ(TbadkApplication.getInst().getSkinType() == 1);
        this.eEA.getLayoutMode().aM(view);
    }

    private String d(UserData userData) {
        long lastReplyTime;
        MembersModel aIV = this.eEA.aIV();
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
                return this.eEA.getPageContext().getString(d.j.members_no_speak);
            }
            return "";
        }
        return am.e(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes3.dex */
    static class b {
        UserIconBox bew = null;
        TextView eDC;
        LinearLayout eEJ;
        TextView eEK;
        ProgressBar eEL;
        ImageView eEM;
        HeadImageView eEN;
        ImageView eEO;
        TextView eEP;
        TextView eEQ;
        View eER;

        b() {
        }
    }
}
