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
/* loaded from: classes17.dex */
public class l extends BaseAdapter {
    private final MembersActivity jqi;
    private a jqj;
    private boolean jqk;
    private boolean jqm;
    private final Set<Long> jqn = new HashSet();
    private final List<UserData> jqo = new ArrayList();
    private ArrayList<IconData> jqp = null;
    private boolean jql = false;

    /* loaded from: classes17.dex */
    public interface a {
        void Bj(int i);
    }

    public void a(a aVar) {
        this.jqj = aVar;
    }

    public void dJ(List<UserData> list) {
        this.jqo.addAll(list);
    }

    public void dK(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.jqo.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void cFo() {
        this.jqn.clear();
    }

    public Set<Long> cFp() {
        return this.jqn;
    }

    public void f(Long l) {
        if (com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.jqn.contains(l)) {
                this.jqn.remove(l);
            } else {
                this.jqn.add(l);
            }
            notifyDataSetChanged();
            if (this.jqj != null) {
                this.jqj.Bj(this.jqn.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.jqo.clear();
        }
        this.jql = false;
        this.jqk = true;
    }

    public l(MembersActivity membersActivity) {
        this.jqi = membersActivity;
    }

    public void qC(boolean z) {
        this.jqk = z;
    }

    public boolean cFq() {
        return this.jqk;
    }

    public void qD(boolean z) {
        this.jql = z;
    }

    public boolean cCa() {
        return this.jqm;
    }

    public void qE(boolean z) {
        this.jqm = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jqo != null) {
            int size = this.jqo.size();
            if (this.jql) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return y.getItem(this.jqo, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.jql && i == getCount() - 1) {
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
        if (this.jqo != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.jqi.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.jqr = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.jqs = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.jqt = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.jqi.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.jqv = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.jqv.setIsRound(false);
                    bVar2.jqv.setAutoChangeStyle(true);
                    bVar2.jpj = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.jqw = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.jqx = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.jqy = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.jqu = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.aiI = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.jqz = inflate2.findViewById(R.id.list_line);
                    bVar2.jqA = inflate2.findViewById(R.id.list_bottom_line);
                    bVar2.jqz.setVisibility(i < getCount() + (-1) ? 0 : 8);
                    bVar2.jqA.setVisibility(i < getCount() + (-1) ? 8 : 0);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.jqk) {
                    bVar.jqs.setText(R.string.members_load_more_person);
                    bVar.jqt.setVisibility(0);
                } else {
                    bVar.jqs.setText(R.string.members_no_more_person);
                    bVar.jqt.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.jqv.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!at.isEmpty(portrait)) {
                        bVar.jqv.startLoad(portrait, 12, false);
                    }
                    bVar.jpj.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.jqw.setVisibility(0);
                            ap.setImageResource(bVar.jqw, R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.jqw.setVisibility(0);
                            ap.setImageResource(bVar.jqw, R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.jqw.setVisibility(8);
                            break;
                    }
                    bVar.jqx.setText(c(userData));
                    bVar.jqy.setText(userData.getPosition());
                    this.jqp = userData.getTShowInfo();
                    if (bVar.aiI != null) {
                        bVar.aiI.a(this.jqp, 2, this.jqi.getResources().getDimensionPixelSize(R.dimen.ds38), this.jqi.getResources().getDimensionPixelSize(R.dimen.ds38), this.jqi.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.jqm) {
                        bVar.jqu.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.jqu.setTag(valueOf);
                        bVar.jqu.setSelected(this.jqn.contains(valueOf));
                        bVar.jqu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.jqn.add(l);
                                    } else {
                                        l.this.jqn.remove(l);
                                    }
                                    if (l.this.jqj != null) {
                                        l.this.jqj.Bj(l.this.jqn.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.jqu.setVisibility(8);
                    }
                    co(view);
                }
            }
        }
        return view;
    }

    private void co(View view) {
        this.jqi.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jqi.getLayoutMode().onModeChanged(view);
    }

    private String c(UserData userData) {
        long lastReplyTime;
        MembersModel cFi = this.jqi.cFi();
        switch (cFi.getOrderType()) {
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
            if (cFi.getOrderType() == 1) {
                return this.jqi.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return at.l(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes17.dex */
    static class b {
        UserIconBox aiI = null;
        TextView jpj;
        View jqA;
        LinearLayout jqr;
        TextView jqs;
        ProgressBar jqt;
        ImageView jqu;
        HeadImageView jqv;
        ImageView jqw;
        TextView jqx;
        TextView jqy;
        View jqz;

        b() {
        }
    }
}
