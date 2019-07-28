package com.baidu.tieba.channel.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.channel.activity.ChannelAddVideoActivity;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private ChannelAddVideoActivity eHK;
    private List<com.baidu.tieba.channel.data.b> mData;

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        this.eHK = channelAddVideoActivity;
    }

    public List<com.baidu.tieba.channel.data.b> getData() {
        return this.mData;
    }

    public void setData(List<com.baidu.tieba.channel.data.b> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData != null) {
            return this.mData.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pL */
    public com.baidu.tieba.channel.data.b getItem(int i) {
        if (this.mData != null) {
            return this.mData.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0297a c0297a;
        if (view != null) {
            c0297a = (C0297a) view.getTag();
        } else {
            view = LayoutInflater.from(this.eHK.getPageContext().getPageActivity()).inflate(R.layout.channel_add_video_item_layout, viewGroup, false);
            C0297a c0297a2 = new C0297a();
            c0297a2.eHL = (TbCheckBox) view.findViewById(R.id.item_check_box);
            c0297a2.eHM = (TbImageView) view.findViewById(R.id.video_cover);
            c0297a2.eHN = (TextView) view.findViewById(R.id.video_length);
            c0297a2.title = (TextView) view.findViewById(R.id.title);
            c0297a2.eHO = (TextView) view.findViewById(R.id.forum_from);
            c0297a2.eHP = (TextView) view.findViewById(R.id.intro);
            view.setTag(c0297a2);
            c0297a = c0297a2;
        }
        com.baidu.tieba.channel.data.b item = getItem(i);
        if (item != null) {
            c0297a.eHL.setTagData(item);
            if (item.baI() == 1) {
                c0297a.eHL.setEnabled(false);
                am.c(c0297a.eHL, (int) R.drawable.icon_choose_channel_n);
            } else {
                c0297a.eHL.setEnabled(true);
                c0297a.eHL.akL();
            }
            if (!TextUtils.isEmpty(item.getThumbnailUrl())) {
                c0297a.eHM.setTag(null);
                c0297a.eHM.startLoad(item.getThumbnailUrl(), 10, false);
                c0297a.eHM.invalidate();
            }
            c0297a.eHN.setText(aq.io(item.getVideoDuration() * 1000));
            if (!TextUtils.isEmpty(item.getTitle())) {
                c0297a.title.setText(item.getTitle());
            }
            if (!TextUtils.isEmpty(item.getForumName())) {
                c0297a.eHO.setText(item.getForumName() + "吧");
            }
            c0297a.eHP.setText(aq.aH(item.baH()) + "次播放·" + com.baidu.tieba.channel.c.c.cG(item.getCreateTime()));
        }
        this.eHK.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.eHK.getLayoutMode().onModeChanged(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getItem(i).baI() != 1;
    }

    /* renamed from: com.baidu.tieba.channel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0297a {
        public TbCheckBox eHL;
        public TbImageView eHM;
        public TextView eHN;
        public TextView eHO;
        public TextView eHP;
        public TextView title;

        public C0297a() {
        }
    }
}
