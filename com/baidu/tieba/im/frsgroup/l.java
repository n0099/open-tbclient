package com.baidu.tieba.im.frsgroup;

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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.R;
import com.baidu.tieba.im.model.MembersModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes23.dex */
public class l extends BaseAdapter {
    private final MembersActivity kal;
    private a kam;
    private boolean kan;
    private boolean kap;
    private final Set<Long> kaq = new HashSet();
    private final List<UserData> kar = new ArrayList();
    private ArrayList<IconData> kas = null;
    private boolean kao = false;

    /* loaded from: classes23.dex */
    public interface a {
        void CJ(int i);
    }

    public void a(a aVar) {
        this.kam = aVar;
    }

    public void ed(List<UserData> list) {
        this.kar.addAll(list);
    }

    public void ee(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.kar.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void cPL() {
        this.kaq.clear();
    }

    public Set<Long> cPM() {
        return this.kaq;
    }

    public void h(Long l) {
        if (com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.kaq.contains(l)) {
                this.kaq.remove(l);
            } else {
                this.kaq.add(l);
            }
            notifyDataSetChanged();
            if (this.kam != null) {
                this.kam.CJ(this.kaq.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.kar.clear();
        }
        this.kao = false;
        this.kan = true;
    }

    public l(MembersActivity membersActivity) {
        this.kal = membersActivity;
    }

    public void rK(boolean z) {
        this.kan = z;
    }

    public boolean cPN() {
        return this.kan;
    }

    public void rL(boolean z) {
        this.kao = z;
    }

    public boolean cMy() {
        return this.kap;
    }

    public void rM(boolean z) {
        this.kap = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kar != null) {
            int size = this.kar.size();
            if (this.kao) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return y.getItem(this.kar, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.kao && i == getCount() - 1) {
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
        if (this.kar != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.kal.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.kau = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.kaw = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.kax = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.kal.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.kaz = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.kaz.setIsRound(false);
                    bVar2.kaz.setAutoChangeStyle(true);
                    bVar2.jZn = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.kaA = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.kaB = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.kaC = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.kay = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.ajx = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.kaD = inflate2.findViewById(R.id.list_line);
                    bVar2.kaE = inflate2.findViewById(R.id.list_bottom_line);
                    bVar2.kaD.setVisibility(i < getCount() + (-1) ? 0 : 8);
                    bVar2.kaE.setVisibility(i < getCount() + (-1) ? 8 : 0);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.kan) {
                    bVar.kaw.setText(R.string.members_load_more_person);
                    bVar.kax.setVisibility(0);
                } else {
                    bVar.kaw.setText(R.string.members_no_more_person);
                    bVar.kax.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.kaz.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!at.isEmpty(portrait)) {
                        bVar.kaz.startLoad(portrait, 12, false);
                    }
                    bVar.jZn.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.kaA.setVisibility(0);
                            ap.setImageResource(bVar.kaA, R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.kaA.setVisibility(0);
                            ap.setImageResource(bVar.kaA, R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.kaA.setVisibility(8);
                            break;
                    }
                    bVar.kaB.setText(c(userData));
                    bVar.kaC.setText(userData.getPosition());
                    this.kas = userData.getTShowInfo();
                    if (bVar.ajx != null) {
                        bVar.ajx.a(this.kas, 2, this.kal.getResources().getDimensionPixelSize(R.dimen.ds38), this.kal.getResources().getDimensionPixelSize(R.dimen.ds38), this.kal.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.kap) {
                        bVar.kay.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.kay.setTag(valueOf);
                        bVar.kay.setSelected(this.kaq.contains(valueOf));
                        bVar.kay.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.kaq.add(l);
                                    } else {
                                        l.this.kaq.remove(l);
                                    }
                                    if (l.this.kam != null) {
                                        l.this.kam.CJ(l.this.kaq.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.kay.setVisibility(8);
                    }
                    cF(view);
                }
            }
        }
        return view;
    }

    private void cF(View view) {
        this.kal.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kal.getLayoutMode().onModeChanged(view);
    }

    private String c(UserData userData) {
        long lastReplyTime;
        MembersModel cPF = this.kal.cPF();
        switch (cPF.getOrderType()) {
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
            if (cPF.getOrderType() == 1) {
                return this.kal.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return at.l(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes23.dex */
    static class b {
        UserIconBox ajx = null;
        TextView jZn;
        ImageView kaA;
        TextView kaB;
        TextView kaC;
        View kaD;
        View kaE;
        LinearLayout kau;
        TextView kaw;
        ProgressBar kax;
        ImageView kay;
        HeadImageView kaz;

        b() {
        }
    }
}
