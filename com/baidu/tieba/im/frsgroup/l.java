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
    private final MembersActivity jqo;
    private a jqp;
    private boolean jqq;
    private boolean jqs;
    private final Set<Long> jqt = new HashSet();
    private final List<UserData> jqu = new ArrayList();
    private ArrayList<IconData> jqv = null;
    private boolean jqr = false;

    /* loaded from: classes17.dex */
    public interface a {
        void Bj(int i);
    }

    public void a(a aVar) {
        this.jqp = aVar;
    }

    public void dJ(List<UserData> list) {
        this.jqu.addAll(list);
    }

    public void dK(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.jqu.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void cFp() {
        this.jqt.clear();
    }

    public Set<Long> cFq() {
        return this.jqt;
    }

    public void f(Long l) {
        if (com.baidu.adp.lib.util.l.isMainThread()) {
            if (this.jqt.contains(l)) {
                this.jqt.remove(l);
            } else {
                this.jqt.add(l);
            }
            notifyDataSetChanged();
            if (this.jqp != null) {
                this.jqp.Bj(this.jqt.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.jqu.clear();
        }
        this.jqr = false;
        this.jqq = true;
    }

    public l(MembersActivity membersActivity) {
        this.jqo = membersActivity;
    }

    public void qE(boolean z) {
        this.jqq = z;
    }

    public boolean cFr() {
        return this.jqq;
    }

    public void qF(boolean z) {
        this.jqr = z;
    }

    public boolean cCb() {
        return this.jqs;
    }

    public void qG(boolean z) {
        this.jqs = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jqu != null) {
            int size = this.jqu.size();
            if (this.jqr) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return y.getItem(this.jqu, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.jqr && i == getCount() - 1) {
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
        if (this.jqu != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.jqo.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    bVar2.jqx = (LinearLayout) inflate.findViewById(R.id.list_more);
                    bVar2.jqy = (TextView) inflate.findViewById(R.id.more_title);
                    bVar2.jqz = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.jqo.getPageContext().getPageActivity()).inflate(R.layout.im_members_list_item, viewGroup, false);
                    bVar2.jqB = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    bVar2.jqB.setIsRound(false);
                    bVar2.jqB.setAutoChangeStyle(true);
                    bVar2.jpp = (TextView) inflate2.findViewById(R.id.item_name);
                    bVar2.jqC = (ImageView) inflate2.findViewById(R.id.item_sex);
                    bVar2.jqD = (TextView) inflate2.findViewById(R.id.item_time);
                    bVar2.jqE = (TextView) inflate2.findViewById(R.id.item_address);
                    bVar2.jqA = (ImageView) inflate2.findViewById(R.id.item_check);
                    bVar2.aiK = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    bVar2.jqF = inflate2.findViewById(R.id.list_line);
                    bVar2.jqG = inflate2.findViewById(R.id.list_bottom_line);
                    bVar2.jqF.setVisibility(i < getCount() + (-1) ? 0 : 8);
                    bVar2.jqG.setVisibility(i < getCount() + (-1) ? 8 : 0);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.jqq) {
                    bVar.jqy.setText(R.string.members_load_more_person);
                    bVar.jqz.setVisibility(0);
                } else {
                    bVar.jqy.setText(R.string.members_no_more_person);
                    bVar.jqz.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.jqB.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!at.isEmpty(portrait)) {
                        bVar.jqB.startLoad(portrait, 12, false);
                    }
                    bVar.jpp.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.jqC.setVisibility(0);
                            ap.setImageResource(bVar.jqC, R.drawable.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.jqC.setVisibility(0);
                            ap.setImageResource(bVar.jqC, R.drawable.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.jqC.setVisibility(8);
                            break;
                    }
                    bVar.jqD.setText(c(userData));
                    bVar.jqE.setText(userData.getPosition());
                    this.jqv = userData.getTShowInfo();
                    if (bVar.aiK != null) {
                        bVar.aiK.a(this.jqv, 2, this.jqo.getResources().getDimensionPixelSize(R.dimen.ds38), this.jqo.getResources().getDimensionPixelSize(R.dimen.ds38), this.jqo.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    }
                    if (this.jqs) {
                        bVar.jqA.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.jqA.setTag(valueOf);
                        bVar.jqA.setSelected(this.jqt.contains(valueOf));
                        bVar.jqA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.jqt.add(l);
                                    } else {
                                        l.this.jqt.remove(l);
                                    }
                                    if (l.this.jqp != null) {
                                        l.this.jqp.Bj(l.this.jqt.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.jqA.setVisibility(8);
                    }
                    co(view);
                }
            }
        }
        return view;
    }

    private void co(View view) {
        this.jqo.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jqo.getLayoutMode().onModeChanged(view);
    }

    private String c(UserData userData) {
        long lastReplyTime;
        MembersModel cFj = this.jqo.cFj();
        switch (cFj.getOrderType()) {
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
            if (cFj.getOrderType() == 1) {
                return this.jqo.getPageContext().getString(R.string.members_no_speak);
            }
            return "";
        }
        return at.l(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes17.dex */
    static class b {
        UserIconBox aiK = null;
        TextView jpp;
        ImageView jqA;
        HeadImageView jqB;
        ImageView jqC;
        TextView jqD;
        TextView jqE;
        View jqF;
        View jqG;
        LinearLayout jqx;
        TextView jqy;
        ProgressBar jqz;

        b() {
        }
    }
}
