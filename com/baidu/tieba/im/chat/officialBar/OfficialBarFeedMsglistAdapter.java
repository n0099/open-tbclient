package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class OfficialBarFeedMsglistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<com.baidu.tbadk.mvc.b.a> akq = new ArrayList<>();
    private c kyV;
    private TbPageContext<?> mPageContext;

    /* loaded from: classes8.dex */
    public interface c {
        void a(View view, Object obj, int i, long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfficialBarFeedMsglistAdapter(TbPageContext<?> tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.kyV = cVar;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.akq.clear();
            this.akq.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.official_bar_feed_header_item, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (this.akq != null && this.akq.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.akq.get(i);
            if ((viewHolder instanceof b) && (aVar instanceof a)) {
                ((b) viewHolder).b(aVar);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.akq == null) {
            return 0;
        }
        return this.akq.size();
    }

    /* loaded from: classes8.dex */
    class b extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView jMX;
        private BarImageView kyX;
        private View kyY;
        private a kyZ;

        b(View view) {
            super(view);
            this.kyX = (BarImageView) view.findViewById(R.id.official_bar_image);
            this.jMX = (TextView) view.findViewById(R.id.official_bar_name);
            this.kyY = view.findViewById(R.id.official_bar_feed_red_dot);
            this.kyX.setShowOval(true);
            this.kyX.setPlaceHolder(2);
            this.kyX.setShowOuterBorder(false);
            this.kyX.setShowInnerBorder(true);
            this.kyX.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        }

        void b(com.baidu.tbadk.mvc.b.a aVar) {
            this.kyZ = (a) aVar;
            ao.setViewTextColor(this.jMX, R.color.CAM_X0105);
            ao.setBackgroundResource(this.kyY, R.drawable.icon_official_bar_red_dot);
            this.kyX.setStrokeColorResId(R.color.CAM_X0401);
            this.kyX.startLoad(this.kyZ.cWK(), 10, false);
            if (at.getChineseAndEnglishLength(this.kyZ.cRb()) <= 10) {
                this.jMX.setText(this.kyZ.cRb());
            } else {
                this.jMX.setText(at.cutChineseAndEnglishWithSuffix(this.kyZ.cRb(), 8, StringHelper.STRING_MORE));
            }
            this.kyX.setOnClickListener(this);
            if (this.kyZ.getUnReadCount() > 0 && (this.kyZ.cWL() <= 0 || System.currentTimeMillis() - this.kyZ.cWL() < 864000000)) {
                this.kyY.setVisibility(0);
            } else {
                this.kyY.setVisibility(8);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.kyY.setVisibility(8);
            if (OfficialBarFeedMsglistAdapter.this.kyV != null) {
                OfficialBarFeedMsglistAdapter.this.kyV.a(view, this.kyZ, getAdapterPosition(), getItemId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a implements com.baidu.tbadk.mvc.b.a {
        private long dbH;
        private long groupId;
        private String jYM;
        private String kyW;
        private int unReadCount;
        private int userType;

        String cWK() {
            return this.kyW;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String cRb() {
            return this.jYM;
        }

        int getUnReadCount() {
            return this.unReadCount;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void MM(String str) {
            this.kyW = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void MN(String str) {
            this.jYM = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setUnReadCount(int i) {
            this.unReadCount = i;
        }

        public void setGroupId(long j) {
            this.groupId = j;
        }

        public void setUserType(int i) {
            this.userType = i;
        }

        public long getGroupId() {
            return this.groupId;
        }

        public long cWL() {
            return this.dbH;
        }

        public void gK(long j) {
            this.dbH = j;
        }
    }
}
