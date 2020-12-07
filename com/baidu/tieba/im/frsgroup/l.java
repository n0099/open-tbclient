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
import com.baidu.tbadk.core.util.au;
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
    private boolean jht;
    private final MembersActivity kur;
    private a kus;
    private boolean kut;
    private final Set<Long> kuv = new HashSet();
    private final List<UserData> kuw = new ArrayList();
    private ArrayList<IconData> kux = null;
    private boolean kuu = false;

    /* loaded from: classes23.dex */
    public interface a {
        void Ej(int i);
    }

    public void a(a aVar) {
        this.kus = aVar;
    }

    public void ew(List<UserData> list) {
        this.kuw.addAll(list);
    }

    public void ex(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.kuw.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void cXe() {
        this.kuv.clear();
    }

    public Set<Long> cXf() {
        return this.kuv;
    }

    public void i(Long l) {
        if (com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.kuv.contains(l)) {
                this.kuv.remove(l);
            } else {
                this.kuv.add(l);
            }
            notifyDataSetChanged();
            if (this.kus != null) {
                this.kus.Ej(this.kuv.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.kuw.clear();
        }
        this.kuu = false;
        this.kut = true;
    }

    public l(MembersActivity membersActivity) {
        this.kur = membersActivity;
    }

    public void sy(boolean z) {
        this.kut = z;
    }

    public boolean cXg() {
        return this.kut;
    }

    public void sz(boolean z) {
        this.kuu = z;
    }

    public boolean cTT() {
        return this.jht;
    }

    public void sA(boolean z) {
        this.jht = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kuw != null) {
            int size = this.kuw.size();
            if (this.kuu) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return y.getItem(this.kuw, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.kuu && i == getCount() - 1) {
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
        if (this.kuw != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.kur.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.kuz = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.kuA = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.kuB = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.kur.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.kuD = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.kuD.setIsRound(false);
                    bVar2.kuD.setAutoChangeStyle(true);
                    bVar2.ktt = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.kuE = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.kuF = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.kuG = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.kuC = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.akB = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.kuH = inflate2.findViewById(R.id.list_line);
                    bVar2.kuI = inflate2.findViewById(R.id.list_bottom_line);
                    bVar2.kuH.setVisibility(i < getCount() + (-1) ? 0 : 8);
                    bVar2.kuI.setVisibility(i < getCount() + (-1) ? 8 : 0);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.kut) {
                    bVar.kuA.setText(R.string.members_load_more_person);
                    bVar.kuB.setVisibility(0);
                } else {
                    bVar.kuA.setText(R.string.members_no_more_person);
                    bVar.kuB.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.kuD.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!au.isEmpty(portrait)) {
                        bVar.kuD.startLoad(portrait, 12, false);
                    }
                    bVar.ktt.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.kuE.setVisibility(0);
                            ap.setImageResource(bVar.kuE, R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.kuE.setVisibility(0);
                            ap.setImageResource(bVar.kuE, R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.kuE.setVisibility(8);
                            break;
                    }
                    bVar.kuF.setText(c(userData));
                    bVar.kuG.setText(userData.getPosition());
                    this.kux = userData.getTShowInfo();
                    if (bVar.akB != null) {
                        bVar.akB.a(this.kux, 2, this.kur.getResources().getDimensionPixelSize(R.dimen.ds38), this.kur.getResources().getDimensionPixelSize(R.dimen.ds38), this.kur.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.jht) {
                        bVar.kuC.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.kuC.setTag(valueOf);
                        bVar.kuC.setSelected(this.kuv.contains(valueOf));
                        bVar.kuC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.kuv.add(l);
                                    } else {
                                        l.this.kuv.remove(l);
                                    }
                                    if (l.this.kus != null) {
                                        l.this.kus.Ej(l.this.kuv.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.kuC.setVisibility(8);
                    }
                    cV(view);
                }
            }
        }
        return view;
    }

    private void cV(View view) {
        this.kur.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kur.getLayoutMode().onModeChanged(view);
    }

    private String c(UserData userData) {
        long lastReplyTime;
        MembersModel cWY = this.kur.cWY();
        switch (cWY.getOrderType()) {
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
            if (cWY.getOrderType() == 1) {
                return this.kur.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return au.l(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes23.dex */
    static class b {
        UserIconBox akB = null;
        TextView ktt;
        TextView kuA;
        ProgressBar kuB;
        ImageView kuC;
        HeadImageView kuD;
        ImageView kuE;
        TextView kuF;
        TextView kuG;
        View kuH;
        View kuI;
        LinearLayout kuz;

        b() {
        }
    }
}
