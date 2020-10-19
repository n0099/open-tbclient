package com.baidu.tieba.im.creategroup;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class i implements o {
    CreateGroupStepActivity jHH;
    private int jHL;
    HeadImageView jIh;
    ImageView jIi;
    TextView jIj;
    private com.baidu.adp.widget.ImageView.a jIk = null;
    private a jIl = null;
    private int mIndex;
    private int mStep;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.jHH = null;
        this.mView = null;
        this.jIh = null;
        this.jIi = null;
        this.jIj = null;
        this.jHH = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.jIi = (ImageView) this.mView.findViewById(R.id.step3_img_bg);
        this.jIh = (HeadImageView) this.mView.findViewById(R.id.step3_img_scr);
        this.jIj = (TextView) this.mView.findViewById(R.id.create_group3);
        this.mIndex = i;
        this.mStep = i2;
        this.jHL = i3;
    }

    public void cKj() {
        if (this.jIl != null) {
            this.jIl.cancel();
        }
        this.jIk = null;
        this.jIl = new a();
        this.jIl.execute(new Object[0]);
    }

    public ImageView cKk() {
        return this.jIi;
    }

    public TextView cKl() {
        return this.jIj;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cJU() {
        this.jIi.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cJV() {
        this.jHH.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jHH.getLayoutMode().onModeChanged(this.mView);
        this.jIh.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.n.getImage(null, TbConfig.GROUP_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (bitmap != null) {
                i.this.jIh.setVisibility(0);
                i.this.jIk = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.jIk.drawImageTo(i.this.jIh);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.jHH.getPageContext().getString(R.string.group_create_step_photo), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cJX() {
        if (this.mIndex != this.jHL) {
            return this.jHH.getPageContext().getString(R.string.next_step);
        }
        return this.jHH.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cJY() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cJO() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cJZ() {
        return true;
    }
}
