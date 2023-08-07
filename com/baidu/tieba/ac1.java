package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class ac1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] AdImageView;
    public static final int AdImageView_adCornerRadius = 0;
    public static final int AdImageView_borderColor = 1;
    public static final int AdImageView_borderColorWidth = 2;
    public static final int AdImageView_circleType = 3;
    public static final int AdImageView_errorHolder = 4;
    public static final int AdImageView_holder = 5;
    public static final int AdImageView_imageScaleType = 6;
    public static final int AdImageView_leftBottomRadius = 7;
    public static final int AdImageView_leftTopRadius = 8;
    public static final int AdImageView_loadingHolder = 9;
    public static final int AdImageView_rightBottomRadius = 10;
    public static final int AdImageView_rightTopRadius = 11;
    public static final int[] ExpandIconView;
    public static final int ExpandIconView_animationDuration = 0;
    public static final int ExpandIconView_color = 1;
    public static final int ExpandIconView_length = 2;
    public static final int ExpandIconView_thick = 3;
    public static final int[] NADUnifyTextView;
    public static final int NADUnifyTextView_spannable_bottom_padding = 0;
    public static final int NADUnifyTextView_spannable_top_padding = 1;
    public static final int[] NadBdThumbSeekBar;
    public static final int NadBdThumbSeekBar_nad_ThumbSeekBarStyle = 0;
    public static final int[] NadEnhanceButtonView;
    public static final int NadEnhanceButtonView_btnBackgroundEndColor = 0;
    public static final int NadEnhanceButtonView_btnBackgroundStartColor = 1;
    public static final int NadEnhanceButtonView_btnCornerRadius = 2;
    public static final int[] NadRoundProgressBar;
    public static final int NadRoundProgressBar_max = 0;
    public static final int NadRoundProgressBar_nad_style = 1;
    public static final int NadRoundProgressBar_reverse = 2;
    public static final int NadRoundProgressBar_roundColor = 3;
    public static final int NadRoundProgressBar_roundHintTextSize = 4;
    public static final int NadRoundProgressBar_roundMax = 5;
    public static final int NadRoundProgressBar_roundPaintCapRound = 6;
    public static final int NadRoundProgressBar_roundProgressColor = 7;
    public static final int NadRoundProgressBar_roundTextColor = 8;
    public static final int NadRoundProgressBar_roundTextSize = 9;
    public static final int NadRoundProgressBar_roundWidth = 10;
    public static final int NadRoundProgressBar_textColor = 11;
    public static final int NadRoundProgressBar_textIsDisplayable = 12;
    public static final int NadRoundProgressBar_textSize = 13;
    public static final int[] NadShadowViewGroup;
    public static final int NadShadowViewGroup_containerCornerRadius = 0;
    public static final int NadShadowViewGroup_containerDeltaHeight = 1;
    public static final int NadShadowViewGroup_containerDeltaWidth = 2;
    public static final int NadShadowViewGroup_containerShadowColor = 3;
    public static final int NadShadowViewGroup_containerShadowRadius = 4;
    public static final int NadShadowViewGroup_deltaX = 5;
    public static final int NadShadowViewGroup_deltaY = 6;
    public static final int NadShadowViewGroup_enable = 7;
    public static final int NadShadowViewGroup_shadowAlpha = 8;
    public static final int[] NadTextProgressView;
    public static final int NadTextProgressView_nad_progressGravity = 0;
    public static final int NadTextProgressView_nad_progressTextColor = 1;
    public static final int NadTextProgressView_nad_progressTextMode = 2;
    public static final int NadTextProgressView_nad_progressTextSize = 3;
    public static final int[] RoundCornerRelativeLayout;
    public static final int RoundCornerRelativeLayout_round_edge_radius = 0;
    public static final int[] SimpleAdInfoView;
    public static final int SimpleAdInfoView_layoutId = 0;
    public static final int[] nad_bdvideoplayer_bdPlayerProgressView;
    public static final int nad_bdvideoplayer_bdPlayerProgressView_nad_bdvideoplayer_progressGravity = 0;
    public static final int nad_bdvideoplayer_bdPlayerProgressView_nad_bdvideoplayer_progressTextColor = 1;
    public static final int nad_bdvideoplayer_bdPlayerProgressView_nad_bdvideoplayer_progressTextMode = 2;
    public static final int nad_bdvideoplayer_bdPlayerProgressView_nad_bdvideoplayer_progressTextSize = 3;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947610266, "Lcom/baidu/tieba/ac1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947610266, "Lcom/baidu/tieba/ac1;");
                return;
            }
        }
        AdImageView = new int[]{R.attr.adCornerRadius, R.attr.obfuscated_res_0x7f0400ea, R.attr.borderColorWidth, R.attr.obfuscated_res_0x7f040161, R.attr.obfuscated_res_0x7f0402a9, R.attr.obfuscated_res_0x7f040346, R.attr.imageScaleType, R.attr.leftBottomRadius, R.attr.leftTopRadius, R.attr.loadingHolder, R.attr.rightBottomRadius, R.attr.rightTopRadius};
        ExpandIconView = new int[]{R.attr.obfuscated_res_0x7f040093, R.attr.obfuscated_res_0x7f040177, R.attr.obfuscated_res_0x7f040456, R.attr.obfuscated_res_0x7f04076e};
        NADUnifyTextView = new int[]{R.attr.obfuscated_res_0x7f0406a8, R.attr.obfuscated_res_0x7f0406a9};
        NadBdThumbSeekBar = new int[]{R.attr.nad_ThumbSeekBarStyle};
        NadEnhanceButtonView = new int[]{R.attr.btnBackgroundEndColor, R.attr.btnBackgroundStartColor, R.attr.btnCornerRadius};
        NadRoundProgressBar = new int[]{R.attr.obfuscated_res_0x7f0404e5, R.attr.nad_style, R.attr.obfuscated_res_0x7f040605, R.attr.obfuscated_res_0x7f040623, R.attr.roundHintTextSize, R.attr.obfuscated_res_0x7f040626, R.attr.obfuscated_res_0x7f040627, R.attr.obfuscated_res_0x7f040629, R.attr.roundTextColor, R.attr.roundTextSize, R.attr.obfuscated_res_0x7f040630, R.attr.obfuscated_res_0x7f040758, R.attr.obfuscated_res_0x7f040762, R.attr.obfuscated_res_0x7f040765};
        NadShadowViewGroup = new int[]{R.attr.obfuscated_res_0x7f040199, R.attr.obfuscated_res_0x7f04019a, R.attr.obfuscated_res_0x7f04019b, R.attr.obfuscated_res_0x7f04019c, R.attr.obfuscated_res_0x7f04019d, R.attr.obfuscated_res_0x7f040253, R.attr.obfuscated_res_0x7f040254, R.attr.obfuscated_res_0x7f04029b, R.attr.obfuscated_res_0x7f040673};
        NadTextProgressView = new int[]{R.attr.nad_progressGravity, R.attr.nad_progressTextColor, R.attr.nad_progressTextMode, R.attr.nad_progressTextSize};
        RoundCornerRelativeLayout = new int[]{R.attr.round_edge_radius};
        SimpleAdInfoView = new int[]{R.attr.obfuscated_res_0x7f040435};
        nad_bdvideoplayer_bdPlayerProgressView = new int[]{R.attr.nad_bdvideoplayer_progressGravity, R.attr.nad_bdvideoplayer_progressTextColor, R.attr.nad_bdvideoplayer_progressTextMode, R.attr.nad_bdvideoplayer_progressTextSize};
    }
}
